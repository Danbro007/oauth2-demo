package com.danbro.springsecurity.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Classname PermissionDto
 * @Description TODO
 * @Date 2020/10/29 9:41
 * @Author Danrbo
 */
@Data
@TableName(value = "t_permission")
public class PermissionDto {
    private Integer id;
    private String code;
    private String description;
    private String url;
}
