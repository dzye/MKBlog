package com.mikey.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mikey.domain.ResponseResult;
import com.mikey.domain.entity.Article;
import com.mikey.domain.vo.ArticleDetailVo;
import com.mikey.domain.vo.ArticleListVo;
import com.mikey.domain.vo.HotArticleVo;
import com.mikey.domain.vo.PageVo;

/**
 * @author mikey
 */
public interface ArticleService extends IService<Article> {
    ResponseResult<HotArticleVo[]> hotArticleList();

    ResponseResult<PageVo<ArticleListVo>> articleList(Integer pageNum, Integer pageSize, Long categoryId);

    ResponseResult<ArticleDetailVo> getArticleDetail(Long id);
}
