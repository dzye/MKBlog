package com.mikey.controller;

import com.mikey.constants.SystemConstants;
import com.mikey.domain.ResponseResult;
import com.mikey.domain.dto.CommentDto;
import com.mikey.domain.vo.CommentVo;
import com.mikey.domain.vo.PageVo;
import com.mikey.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
     * 获取文章评论列表
     * @param pageNum 页码
     * @param pageSize 每页数量
     * @param articleId 文章Id
     */
    @GetMapping("/commentList")
    public ResponseResult<PageVo<CommentVo>> commentList(Integer pageNum, Integer pageSize, Long articleId){
        return commentService.commentList(SystemConstants.ARTICLE_COMMENT,pageNum,pageSize,articleId);
    }
    /**
     * 发表评论
     */
    @PostMapping
    public ResponseResult addComment(@RequestBody CommentDto commentDto){
        return commentService.addComment(commentDto);
    }
    /**
     * 获取友链评论列表
     * @param pageNum 页码
     * @param pageSize 每页数量
     * @param articleId 文章Id
     */
    @GetMapping("/linkCommentList")
    public ResponseResult<PageVo<CommentVo>> linkCommentList(Integer pageNum, Integer pageSize, Long articleId){
        return commentService.commentList(SystemConstants.LINK_COMMENT,pageNum,pageSize,articleId);
    }
}
