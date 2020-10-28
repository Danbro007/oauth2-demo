package com.danbro.springsecurity.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

/**
 * @Classname UserDto
 * @Description TODO
 * @Date 2020/10/27 11:38
 * @Author Danrbo
 */
@Data
@Builder
@AllArgsConstructor
public class UserDto {
    public final static String SESSION_KEY = "user_";
    private Integer id;
    private String username;
    private String password;
    private String fullName;
    private String mobile;
    /**
     * 权限集合
     */
    private Set<String> authorities;
}
