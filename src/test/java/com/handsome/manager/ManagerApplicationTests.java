package com.handsome.manager;

import com.handsome.manager.model.TEduSales;
import com.handsome.manager.service.TEduSalesService;
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
	private TEduSalesService tEduSalesService;

	@Test
	public void contextLoads() {
		// 所有用户
		List<TEduSales> users = tEduSalesService.selectList(null);
		System.out.println(users);
	}

}
