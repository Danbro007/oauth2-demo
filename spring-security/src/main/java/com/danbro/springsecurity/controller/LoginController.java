package com.danbro.springsecurity.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Classname LoginController
 * @Description TODO
 * @Date 2020/10/27 13:47
 * @Author Danrbo
 */
@Controller
public class LoginController {
    @PreAuthorize("hasAuthority('p1')")
    @ResponseBody
    @GetMapping(value = "/r/r1")
    public String r1() {
        return getUsername() + "正在访问资源r1！";
    }
    @PreAuthorize("hasAuthority('p2')")
    @ResponseBody
    @GetMapping(value = "/r/r2")
    public String r2() {
        return getUsername() + "正在访问资源r2！";
    }

    @ResponseBody
    @RequestMapping(value = "/login-success")
    public String loginSuccess() {
        return getUsername();
    }

    private String getUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!authentication.isAuthenticated()) {
            throw new UsernameNotFoundException("用户不合法！");
        }
        String username = null;
        Object principal = authentication.getPrincipal();
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        }
        return username;

    }

    @GetMapping("/index")
    public String index() {
        return "login";
    }

}
