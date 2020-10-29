package com.danbro.springsecurity.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.beans.Transient;
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
@NoArgsConstructor
@TableName(value = "t_user")
public class UserDto {
    private Integer id;
    private String username;
    private String password;
//    @TableField(exist = false)
//    private String fullName;
//    @TableField(exist = false)
//    private String mobile;
    /**
     * 权限集合
     */
//    @TableField(exist = false)
//    private Set<String> authorities;
}
