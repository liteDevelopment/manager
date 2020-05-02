package com.handsome.manager;

import com.handsome.manager.model.User;
import com.handsome.manager.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ManagerApplicationTests {

	@Resource
	private UserService userService;

	@Test
	public void contextLoads() {
		// 所有用户
		List<User> users = userService.selectList(null);
		System.out.println(users);
	}

}
