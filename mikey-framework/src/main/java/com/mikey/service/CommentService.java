package com.mikey.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mikey.domain.ResponseResult;
import com.mikey.domain.dto.CommentDto;
import com.mikey.domain.entity.Comment;
import com.mikey.domain.vo.CommentVo;
import com.mikey.domain.vo.PageVo;

/**
 * 评论表(Comment)表服务接口
 *
 * @author mikey
 * @since 2024-03-07 13:39:59
 */
public interface CommentService extends IService<Comment> {
    ResponseResult<PageVo<CommentVo>> commentList(String commentType, Integer pageNum, Integer pageSize, Long articleId);

    ResponseResult addComment(CommentDto commentDto);
}
