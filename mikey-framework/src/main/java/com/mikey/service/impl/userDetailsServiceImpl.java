package com.mikey.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.mikey.domain.entity.LoginUser;
import com.mikey.domain.entity.User;
import com.mikey.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class userDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(User::getUserName, userName);
        User user = userMapper.selectOne(lambdaQueryWrapper);
        if(Objects.isNull(user)){
            throw new RuntimeException("用户名不存在");
        }
        //  TODO  查询权限信息封装
        return new LoginUser(user);
    }
}
