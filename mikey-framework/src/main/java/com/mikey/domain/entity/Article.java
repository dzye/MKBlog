package com.mikey.domain.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 文章表(Article)表实体类
 *
 * @author mikey
 * @since 2024-01-27 12:12:26
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("mk_article")
@Accessors(chain = true)
public class Article {
    @TableId
    private Long id;
    //标题
    private String title;
    //文章内容
    private String content;
    //文章摘要
    private String summary;
    //所属分类id
    private Long categoryId;
    //所属分类名称
    @TableField(exist = false)
    private String categoryName;
    //缩略图
    private String thumbnail;
    //是否置顶（0 否，1 是）
    private String isTop;
    //状态（0 已发布，1 草稿）
    private String status;
    //访问量
    private Long viewCount;
    //是否允许评论 1是，0否
    private String isComment;

    private Long createBy;

    private Date createTime;

    private Long updateBy;

    private Date updateTime;
    //删除标志（0 代表未删除，1 代表已删除）
    private Integer delFlag;
}

