package com.danbro.session.service;

import com.danbro.session.entity.AuthenticationRequest;
import com.danbro.session.entity.UserDto;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @Classname AuthenticationServiceImpl
 * @Description TODO
 * @Date 2020/10/27 11:39
 * @Author Danrbo
 */
@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private HashMap<String, UserDto> userMap = new HashMap<>();

    {
        Set<String> authoritiesList1 = new HashSet<>();
        authoritiesList1.add("p1");
        Set<String> authoritiesList2 = new HashSet<>();
        authoritiesList2.add("p2");
        userMap.put("josh", new UserDto(1, "josh", "123", "josh wang", "123", authoritiesList1));
        userMap.put("danbro", new UserDto(2, "danbro", "123", "danbro shan", "456", authoritiesList2));
    }

    private UserDto getUser(String username) {
        {
            return userMap.get(username);
        }

    }

    @Override
    public UserDto authentication(AuthenticationRequest authenticationRequest) {
        if (authenticationRequest == null ||
                StringUtils.isEmpty(authenticationRequest.getPassword()) ||
                StringUtils.isEmpty(authenticationRequest.getUsername())) {
            throw new RuntimeException("参数不合法！");
        }
        UserDto userDto = getUser(authenticationRequest.getUsername());
        if (userDto == null) {
            throw new RuntimeException("用户不存在！");
        }
        if (!userDto.getPassword().equals(authenticationRequest.getPassword())) {
            throw new RuntimeException("密码错误！");
        }
        return userDto;
    }
}
