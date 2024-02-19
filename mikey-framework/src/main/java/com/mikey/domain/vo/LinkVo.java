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
public class LinkVo {
    private Long id;
    /**
     * 名称
     */
    private String name;
    /**
     * logo
     */
    private String logo;
    /**
     * 描述
     */
    private String description;
    /**
     * 链接地址
     */
    private String address;
}
