package com.danbro.springsecurity;

import com.danbro.springsecurity.entity.PermissionDto;
import com.danbro.springsecurity.mapper.UserDtoMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.util.List;

@SpringBootTest
class SpringSecurityApplicationTests {
	@Autowired
	UserDtoMapper userDtoMapper;

	@Test
	void test1() {
		String hashpw = BCrypt.hashpw("456", BCrypt.gensalt());
		System.out.println(hashpw);
		// 原始密码和加密后的密码进行比对
		boolean result = BCrypt.checkpw("123", "$2a$10$cG5hXu4HlRqdDwDwxdT9Y.9AJhTSugnB1PFztoRENlt/HVHUKjLd2");
		System.out.println(result);
	}

	@Test
	void test2(){
		List<PermissionDto> permissionDtoList = userDtoMapper.getPermissionByUserId(1);
		permissionDtoList.forEach(System.out::println);
	}

}
