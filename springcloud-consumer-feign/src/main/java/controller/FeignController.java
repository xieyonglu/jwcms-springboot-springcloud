package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import client.UserFeignClient;
import model.User;

@RestController
@RequestMapping("/orderclient")
public class FeignController {

	@Autowired
	private UserFeignClient userFeignClient;

	@GetMapping("/order/{id}")
	public User queryById(@PathVariable Long id) {
		// 调用feign的接口的方法
		System.out.println("FeignController==>" + id);
		User user = userFeignClient.queryById(id);
		return user;
	}
}
