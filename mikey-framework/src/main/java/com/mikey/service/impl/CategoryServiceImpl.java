package com.mikey.service.impl;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mikey.constants.SystemConstants;
import com.mikey.domain.ResponseResult;
import com.mikey.domain.entity.Article;
import com.mikey.domain.entity.Category;
import com.mikey.domain.vo.CategoryVo;
import com.mikey.mapper.CategoryMapper;
import com.mikey.service.ArticleService;
import com.mikey.service.CategoryService;
import com.mikey.utils.BeanCopyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 分类表(Category)表服务实现类
 *
 * @author mikey
 * @since 2024-02-05 16:08:53
 */
@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {
    @Autowired
    private ArticleService articleService;

    @Override
    public ResponseResult<CategoryVo[]> getCategoryList() {
        LambdaQueryWrapper<Article> articleWrapper = new LambdaQueryWrapper<>();
        articleWrapper.eq(Article::getStatus, SystemConstants.ARTICLE_STATUS_NORMAL);
        List<Article> articleList = articleService.list(articleWrapper);
        Set<Long> categoryIds = articleList.stream()
                .map(article -> article.getCategoryId())
                .collect(Collectors.toSet());
        List<Category> categories = listByIds(categoryIds);
        List<Category> categorieList = categories.stream()
                .filter(category -> SystemConstants.STATUS_NORMAL.equals(category.getStatus()))
                .collect(Collectors.toList());
        List<CategoryVo> categoryVos = BeanCopyUtils.copyBeanList(categorieList, CategoryVo.class);

        return ResponseResult.okResult(categoryVos);
    }
}
