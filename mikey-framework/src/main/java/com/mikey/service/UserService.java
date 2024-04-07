package com.mikey.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mikey.domain.ResponseResult;
import com.mikey.domain.entity.User;
import com.mikey.domain.vo.UserInfoVo;

/**
 * 用户表(User)表服务接口
 *
 * @author mikey
 * @since 2024-03-07 15:02:10
 */
public interface UserService extends IService<User> {
    ResponseResult<UserInfoVo> userInfo();
}
