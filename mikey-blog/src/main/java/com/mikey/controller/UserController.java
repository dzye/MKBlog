package com.mikey.controller;

import com.mikey.domain.ResponseResult;
import com.mikey.domain.vo.UserInfoVo;
import com.mikey.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 获取个人信息
     * @return
     */
    @GetMapping("/userInfo")
    public ResponseResult<UserInfoVo> userInfo(){
        return userService.userInfo();
    }
}
