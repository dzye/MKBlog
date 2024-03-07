package com.mikey.service;

import com.mikey.domain.ResponseResult;
import com.mikey.domain.entity.User;

public interface BlogLoginService {
    ResponseResult login(User user);

    ResponseResult logout();
}
