package com.danbro.session.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Classname IndexController
 * @Description TODO
 * @Date 2020/10/27 12:15
 * @Author Danrbo
 */
@Controller
public class IndexController {
    @GetMapping("/")
    public String index() {
        return "index";
    }
}
