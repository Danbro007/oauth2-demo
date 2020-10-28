package com.danbro.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Classname LoginController
 * @Description TODO
 * @Date 2020/10/27 13:47
 * @Author Danrbo
 */
@Controller
public class LoginController {
    @ResponseBody
    @GetMapping(value = "/r/r1")
    public String r1() {
        return "正在访问资源r1！";
    }

    @ResponseBody
    @GetMapping(value = "/r/r2")
    public String r2() {
        return "正在访问资源r2！";
    }

    @ResponseBody
    @RequestMapping(value = "/login-success")
    public String loginSuccess() {
        return "login successful";
    }
    @GetMapping("/index")
    public String index(){
        return "index";
    }

}
