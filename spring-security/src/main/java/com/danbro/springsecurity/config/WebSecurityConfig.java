package com.danbro.springsecurity.config;

import com.danbro.springsecurity.service.SpringDataUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @Classname WebSecurityConfig
 * @Description TODO
 * @Date 2020/10/27 13:49
 * @Author Danrbo
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    /**
     * 负责登录验证
     */
    @Bean
    public UserDetailsService getUserDetailsService() {
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        manager.createUser(User.withUsername("josh").password("$2a$10$cG5hXu4HlRqdDwDwxdT9Y.9AJhTSugnB1PFztoRENlt/HVHUKjLd2").authorities("p1").build());
//        manager.createUser(User.withUsername("danbro").password("$2a$10$cG5hXu4HlRqdDwDwxdT9Y.9AJhTSugnB1PFztoRENlt/HVHUKjLd2").authorities("p2").build());
//        return manager;
        return new SpringDataUserDetailsService();
    }

    /**
     * 负责密码加密
     */
    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(getUserDetailsService()).passwordEncoder(getPasswordEncoder());
    }

    /**
     * 负责安全拦截配置
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/r/r1").hasAnyAuthority("p1")// 基于角色的权限
                .antMatchers("/r/r2").hasAnyAuthority("p2")
                .antMatchers("/r/**").authenticated().
                anyRequest().permitAll().// 对 /r/** 的路径进行认证
                and().formLogin().// 允许表单登录
                loginPage("/login-view").// 指定自定义的登录页面
                successForwardUrl("/login-success").// 登录成功跳转的页面
                loginProcessingUrl("/login").//
                permitAll().// 允许所有用户访问我们的登录页
                and().csrf().disable(); // 关闭 CSRF
    }
}
