package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import client.UserFeignHystrixClient01;
import client.UserFeignHystrixClient02;
import model.User;

@RestController
@RequestMapping("/user")
public class FeignWithHystrixController {

	@Autowired
	private UserFeignHystrixClient01 userFeignHystrixClient01;
	
	@Autowired
	private UserFeignHystrixClient02 userFeignHystrixClient02;

	@GetMapping("/query_by_id01/{id}")
	public User queryById01(@PathVariable Long id) {
		// 调用feign的接口的方法
		System.out.println("FeignController==>" + id);
		User user = userFeignHystrixClient01.findById(id);
		return user;
	}
	
	@GetMapping("/query_by_id02/{id}")
	public User queryById02(@PathVariable Long id) {
		// 调用feign的接口的方法
		System.out.println("FeignController==>" + id);
		User user = userFeignHystrixClient02.findById(id);
		return user;
	}
	
}
