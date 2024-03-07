package com.mikey.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mikey.domain.entity.User;
import com.mikey.mapper.UserMapper;
import com.mikey.service.UserService;
import org.springframework.stereotype.Service;
/**
 * 用户表(User)表服务实现类
 *
 * @author mikey
 * @since 2024-03-07 15:02:11
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
