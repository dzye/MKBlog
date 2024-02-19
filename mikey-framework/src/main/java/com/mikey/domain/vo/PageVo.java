package com.mikey.domain.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author mikey
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageVo<T> {
    /**
     * 分页数据
     */
    private List<T> rows;
    /**
     * 总条数
     */
    private Long total;
}
