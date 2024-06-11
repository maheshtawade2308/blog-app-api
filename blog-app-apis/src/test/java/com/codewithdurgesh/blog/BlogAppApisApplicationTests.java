package com.codewithdurgesh.blog;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.codewithdurgesh.blog.repository.UserRepo;
import com.codewithdurgesh.blog.service.UserService;

@SpringBootTest
class BlogAppApisApplicationTests {

	@Autowired
	private UserRepo userRepo;
	@Test
	void contextLoads() {
	}
	
	@Test
	public void repoTest() {
		String name = userRepo.getClass().getName();
		System.out.println(name);
		String packName = userRepo.getClass().getPackageName();
		System.out.println(packName);

	}

}
