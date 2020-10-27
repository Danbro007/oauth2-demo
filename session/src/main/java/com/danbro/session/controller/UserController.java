package com.danbro.session.controller;

import com.danbro.session.entity.AuthenticationRequest;
import com.danbro.session.entity.UserDto;
import com.danbro.session.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @Classname UserController
 * @Description TODO
 * @Date 2020/10/27 11:21
 * @Author Danrbo
 */
@RestController
public class UserController {
    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping(value = "/login",produces = "text/plain;charset=utf-8")
    public String login(AuthenticationRequest authenticationRequest, HttpSession session){
        UserDto userDto = authenticationService.authentication(authenticationRequest);
        session.setAttribute(UserDto.SESSION_KEY,userDto);
        return userDto.getUsername() + "登录成功！";
    }

    @GetMapping(value = "/r/r1",produces = "text/plain;charset=utf-8")
    public String r1(HttpSession session){
        UserDto userDto = (UserDto) session.getAttribute(UserDto.SESSION_KEY);
        if (userDto == null){
            return "匿名访问";
        }
        return userDto.getUsername() + "正在访问资源r1！";
    }


    @GetMapping(value = "/r/r2",produces = "text/plain;charset=utf-8")
    public String r2(HttpSession session){
        UserDto userDto = (UserDto) session.getAttribute(UserDto.SESSION_KEY);
        if (userDto == null){
            return "匿名访问";
        }
        return userDto.getUsername() + "正在访问资源r2！";
    }


    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "退出登录！";
    }
}
