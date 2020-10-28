package com.danbro.springsecurity;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCrypt;

@SpringBootTest
class SpringSecurityApplicationTests {

	@Test
	void test1() {
		String hashpw = BCrypt.hashpw("456", BCrypt.gensalt());
		System.out.println(hashpw);
		// 原始密码和加密后的密码进行比对
		boolean result = BCrypt.checkpw("123", "$2a$10$cG5hXu4HlRqdDwDwxdT9Y.9AJhTSugnB1PFztoRENlt/HVHUKjLd2");
		System.out.println(result);
	}

}
