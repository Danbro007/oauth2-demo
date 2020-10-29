package com.danbro.springsecurity.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.danbro.springsecurity.entity.PermissionDto;
import com.danbro.springsecurity.entity.UserDto;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Classname UserDtoMapper
 * @Description TODO
 * @Date 2020/10/28 19:00
 * @Author Danrbo
 */
@Resource
public interface UserDtoMapper extends BaseMapper<UserDto> {
    List<PermissionDto> getPermissionByUserId(Integer userId);
}
