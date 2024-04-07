package com.mikey.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mikey.constants.SystemConstants;
import com.mikey.domain.ResponseResult;
import com.mikey.domain.dto.CommentDto;
import com.mikey.domain.entity.Comment;
import com.mikey.domain.vo.CommentVo;
import com.mikey.domain.vo.PageVo;
import com.mikey.enums.AppHttpCodeEnum;
import com.mikey.exception.SystemException;
import com.mikey.mapper.CommentMapper;
import com.mikey.service.CommentService;
import com.mikey.service.UserService;
import com.mikey.utils.BeanCopyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * 评论表(Comment)表服务实现类
 *
 * @author mikey
 * @since 2024-03-07 13:39:59
 */
@Service("commentService")
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {
    @Autowired
    private UserService userService;

    @Override
    public ResponseResult<PageVo<CommentVo>> commentList(String commentType, Integer pageNum, Integer pageSize, Long articleId) {
        LambdaQueryWrapper<Comment> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(SystemConstants.ARTICLE_COMMENT.equals(commentType),Comment::getArticleId, articleId);
        lambdaQueryWrapper.eq(Comment::getRootId, -1);
        lambdaQueryWrapper.eq(Comment::getType, commentType);
        Page<Comment> page = new Page(pageNum, pageSize);
        page(page, lambdaQueryWrapper);
        List<CommentVo> commentListVos = toCommentVoList(page.getRecords());
        for (CommentVo commentVo : commentListVos) {
            List<CommentVo> children = getChildren(commentVo.getId());
            commentVo.setChildren(children);
        }
        return ResponseResult.okResult(new PageVo(commentListVos, page.getTotal()));
    }

    @Override
    public ResponseResult addComment(CommentDto commentDto) {
        if (!StringUtils.hasText(commentDto.getContent())) {
            throw new SystemException(AppHttpCodeEnum.CONTENT_NOT_NULL);
        }
        Comment comment = BeanCopyUtils.copyBean(commentDto, Comment.class);
        save(comment);
        return ResponseResult.okResult();
    }

    private List<CommentVo> getChildren(Long id) {
        LambdaQueryWrapper<Comment> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Comment::getRootId, id);
        queryWrapper.orderByAsc(Comment::getCreateTime);
        List<Comment> comments = list(queryWrapper);
        List<CommentVo> commentVos = toCommentVoList(comments);
        return commentVos;
    }

    private List<CommentVo> toCommentVoList(List<Comment> list) {
        List<CommentVo> commentVos = BeanCopyUtils.copyBeanList(list, CommentVo.class);
        for (CommentVo commentVo : commentVos) {
            String nickName = userService.getById(commentVo.getCreateBy()).getNickName();
            commentVo.setUsername(nickName);
            if (commentVo.getToCommentUserId() != -1) {
                String toCommentUserName = userService.getById(commentVo.getToCommentUserId()).getNickName();
                commentVo.setToCommentUserName(toCommentUserName);
            }
        }
        return commentVos;
    }
}
