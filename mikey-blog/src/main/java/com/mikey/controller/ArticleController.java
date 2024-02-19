package com.mikey.controller;

import com.mikey.domain.ResponseResult;
import com.mikey.domain.vo.ArticleDetailVo;
import com.mikey.domain.vo.ArticleListVo;
import com.mikey.domain.vo.HotArticleVo;
import com.mikey.domain.vo.PageVo;
import com.mikey.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 文章
 *
 * @author mikey
 */
@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    /**
     * 获取热门文章列表
     * @return
     */
    @GetMapping("/hotArticleList")
    public ResponseResult<HotArticleVo[]> hotArticleList() {
        return articleService.hotArticleList();
    }

    /**
     * 获取文章列表
     * @param pageNum 页码
     * @param pageSize 每页数量
     * @param categoryId 分类Id
     */
    @GetMapping("/articleList")
    public ResponseResult<PageVo<ArticleListVo>> articleList(Integer pageNum, Integer pageSize, Long categoryId) {
        return articleService.articleList(pageNum, pageSize, categoryId);
    }

    /**
     * 获取文章详情
     * @param id 文章id
     */
    @GetMapping("/{id}")
    public ResponseResult<ArticleDetailVo> getArticleDetail(@PathVariable("id") Long id) {
        return articleService.getArticleDetail(id);
    }


}
