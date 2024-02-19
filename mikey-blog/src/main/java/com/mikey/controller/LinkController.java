package com.mikey.controller;

import com.mikey.domain.vo.LinkVo;
import com.mikey.service.LinkService;
import com.mikey.domain.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 友链
 *
 * @author mikey
 * @since 2024-02-05 17:56:36
 */
@RestController
@RequestMapping("/link")
public class LinkController {
    @Autowired
    private LinkService linkService;
    /**
     * 获取友链
     */
    @GetMapping("/getAllLink")
    public ResponseResult<LinkVo[]> getAllLink() {
        return linkService.getAllLink();
    }
}
