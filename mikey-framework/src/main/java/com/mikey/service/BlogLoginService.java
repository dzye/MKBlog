package com.mikey.service;

import com.mikey.domain.ResponseResult;
import com.mikey.domain.dto.LoginUserDto;

public interface BlogLoginService {
    ResponseResult login(LoginUserDto loginUserDto);

    ResponseResult logout();
}
