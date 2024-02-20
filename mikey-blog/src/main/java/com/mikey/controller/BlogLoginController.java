package com.mikey.controller;

import com.mikey.domain.ResponseResult;
import com.mikey.domain.entity.User;
import com.mikey.domain.vo.BlogUserLoginVo;
import com.mikey.service.BlogLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
/**
 * 登录
 *
 * @author mikey
 */
@RestController
public class BlogLoginController {
    @Autowired
    BlogLoginService blogLoginService;
    /**
     * 登录接口
     * @return
     */
    @PostMapping("/login")
    public ResponseResult<BlogUserLoginVo> login(@RequestBody User user) {
        return  blogLoginService.login(user);
    }
}
