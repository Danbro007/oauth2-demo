package com.danbro.session.interceptor;

import com.danbro.session.entity.UserDto;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Classname SimpleAuthenticationInterceptor
 * @Description TODO
 * @Date 2020/10/27 12:52
 * @Author Danrbo
 */
@Component
public class SimpleAuthenticationInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        UserDto userDto = (UserDto) session.getAttribute(UserDto.SESSION_KEY);
        if (userDto == null) {
            write(response, "用户未登录！");
            return false;
        }
        String requestURI = request.getRequestURI();
        if (userDto.getAuthorities().contains("p1") && requestURI.contains("r1")) {
            return true;
        }

        if (userDto.getAuthorities().contains("p2") && requestURI.contains("r2")) {
            return true;
        }
        write(response, "用户没有权限");
        return false;
    }

    private void write(HttpServletResponse response, String msg) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.println(msg);
        writer.close();
    }
}
