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
public class CategoryVo {
    /**
     * 主键
     */
    private Long id;
    /**
     * 分类名
     */
    private String name;
}
