package com.mikey.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mikey.domain.ResponseResult;
import com.mikey.domain.entity.User;
import com.mikey.domain.vo.UserInfoVo;
import com.mikey.mapper.UserMapper;
import com.mikey.service.UserService;
import com.mikey.utils.BeanCopyUtils;
import com.mikey.utils.SecurityUtils;
import org.springframework.stereotype.Service;
/**
 * 用户表(User)表服务实现类
 *
 * @author mikey
 * @since 2024-03-07 15:02:11
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Override
    public ResponseResult<UserInfoVo> userInfo(){
        Long userId = SecurityUtils.getUserId();
        User user = getById(userId);
        UserInfoVo userInfoVo = BeanCopyUtils.copyBean(user,UserInfoVo.class);
        return ResponseResult.okResult(userInfoVo);
    }
}
