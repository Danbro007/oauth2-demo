package com.danbro.session.entity;

import lombok.Data;

/**
 * @Classname AuthenticationRequest
 * @Description TODO
 * @Date 2020/10/27 11:38
 * @Author Danrbo
 */
@Data
public class AuthenticationRequest {
    private String username;
    private String password;

}
