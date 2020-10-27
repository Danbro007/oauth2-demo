package com.danbro.session.config;

import com.danbro.session.interceptor.SimpleAuthenticationInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname WebConfig
 * @Description TODO
 * @Date 2020/10/27 12:52
 * @Author Danrbo
 */
@Configuration
public class WebConfig extends WebMvcConfigurationSupport {
    @Autowired
    SimpleAuthenticationInterceptor simpleAuthenticationInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        List<String> excludePatternList = new ArrayList<>();
        excludePatternList.add("/");
        excludePatternList.add("/login");
        registry.addInterceptor(simpleAuthenticationInterceptor).excludePathPatterns(excludePatternList);
    }
}
