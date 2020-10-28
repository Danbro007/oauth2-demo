package com.danbro.springsecurity.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @Classname MyUserDetailsService
 * @Description TODO
 * @Date 2020/10/27 20:39
 * @Author Danrbo
 */
//@Service
public class MyUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 这里使用静态数据来模拟到数据库查询用户
        System.out.println("---->" + username);
        return User.withUsername(username).password("$2a$10$cG5hXu4HlRqdDwDwxdT9Y.9AJhTSugnB1PFztoRENlt/HVHUKjLd2").authorities("p1").build();
    }

}
