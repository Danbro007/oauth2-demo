package com.danbro.springsecurity.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.danbro.springsecurity.entity.UserDto;
import com.danbro.springsecurity.mapper.UserDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Classname SpringDataUserDetailsService
 * @Description TODO
 * @Date 2020/10/28 18:56
 * @Author Danrbo
 */
@Service
public class SpringDataUserDetailsService implements UserDetailsService {
    @Autowired
    UserDtoMapper userDtoMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        QueryWrapper<UserDto> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        UserDto userDto = userDtoMapper.selectOne(queryWrapper);
        if (userDto == null) {
            throw new UsernameNotFoundException("用户不存在！");
        }
        List<GrantedAuthority> authorities = AuthorityUtils.commaSeparatedStringToAuthorityList("p1");
        return User.withUsername(userDto.getUsername()).password(userDto.getPassword()).authorities(authorities).build();
    }
}
