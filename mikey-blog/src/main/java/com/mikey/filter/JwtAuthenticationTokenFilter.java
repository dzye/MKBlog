package com.mikey.filter;

import com.alibaba.fastjson.JSON;
import com.mikey.domain.ResponseResult;
import com.mikey.domain.entity.LoginUser;
import com.mikey.enums.AppHttpCodeEnum;
import com.mikey.utils.JwtUtil;
import com.mikey.utils.RedisCache;
import com.mikey.utils.WebUtils;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {
    @Autowired
    private RedisCache redisCache;
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        String token = httpServletRequest.getHeader("token");
        if(!StringUtils.hasText(token)){
            filterChain.doFilter(httpServletRequest,httpServletResponse);
            return;
        }
        Claims claims = null;
        try{
            claims = JwtUtil.parseJWT(token);
        }catch (Exception e){
            e.printStackTrace();
            ResponseResult result = ResponseResult.errorResult(AppHttpCodeEnum.NEED_LOGIN);
            WebUtils.renderString(httpServletResponse, JSON.toJSONString(result));
            return;
        }
        String userId = claims.getSubject();
        LoginUser loginUser = redisCache.getCacheObject("bloglogin:" + userId);
        if(Objects.isNull(loginUser)){
            ResponseResult result = ResponseResult.errorResult(AppHttpCodeEnum.NEED_LOGIN);
            WebUtils.renderString(httpServletResponse, JSON.toJSONString(result));
            return;
        }
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginUser,null,null);
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);

        filterChain.doFilter(httpServletRequest,httpServletResponse);
    }
}
