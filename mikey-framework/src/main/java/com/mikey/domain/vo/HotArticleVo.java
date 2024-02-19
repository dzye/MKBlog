package com.mikey.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author mikey
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HotArticleVo {
    /**
     * 主键id
     */
    private Long id;
    /**
     * 标题
     */
    private String title;
    /**
     * 访问量
     */
    private Long viewCount;
}
