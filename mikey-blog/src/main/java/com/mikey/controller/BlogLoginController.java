package com.mikey.controller;

import com.mikey.domain.ResponseResult;
import com.mikey.domain.dto.LoginUserDto;
import com.mikey.enums.AppHttpCodeEnum;
import com.mikey.exception.SystemException;
import com.mikey.service.BlogLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
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
     *
     * @return
     */
    @PostMapping("/login")
    public ResponseResult login(@RequestBody LoginUserDto loginUserDto) {
        if(!StringUtils.hasText(loginUserDto.getUserName())){
            throw new SystemException(AppHttpCodeEnum.REQUIRE_USERNAME);
        }
        return  blogLoginService.login(loginUserDto);
    }
    /**
     * 退出登录
     */
    @PostMapping("logout")
    public ResponseResult logout(){
        return blogLoginService.logout();
    }
}
