package com.mikey.controller;

import com.mikey.domain.ResponseResult;
import com.mikey.domain.vo.CommentVo;
import com.mikey.domain.vo.PageVo;
import com.mikey.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 评论
 *
 * @author mikey
 */
@RestController
@RequestMapping("/comment")
public class CommonController {
    @Autowired
    private CommentService commentService;

    /**
     * 获取评论列表
     * @param pageNum 页码
     * @param pageSize 每页数量
     * @param articleId 文章Id
     */
    @GetMapping("/commentList")
    public ResponseResult<PageVo<CommentVo>> commentList(Integer pageNum, Integer pageSize, Long articleId){
        return commentService.commentList(pageNum,pageSize,articleId);
    }
}
