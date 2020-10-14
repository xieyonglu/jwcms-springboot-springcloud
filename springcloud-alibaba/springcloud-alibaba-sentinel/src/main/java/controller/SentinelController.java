package controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.csp.sentinel.annotation.SentinelResource;

@RestController
public class SentinelController {

	@GetMapping("/test")
	public String test() {
		return "hello! sentinel!";
	}

	@SentinelResource("test2")
	@GetMapping("/myTest")
	public String test2(String name, Integer age) {
		return "hello! sentinel!" + name + age;
	}

}
