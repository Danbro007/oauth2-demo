package com.danbro.session.service;

import com.danbro.session.entity.AuthenticationRequest;
import com.danbro.session.entity.UserDto;

/**
 * @Classname AuthenticationService
 * @Description TODO
 * @Date 2020/10/27 11:26
 * @Author Danrbo
 */
public interface AuthenticationService {
    /**
     * 用户认证
     * @param authenticationRequest 用户发送的请求
     * @return 用户消息
     */
    UserDto authentication(AuthenticationRequest authenticationRequest);
}
