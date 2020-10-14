package client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fallback.FeignHystrixFallback;
import model.User;

/**
 * 使用@FeignClient注解的fallback属性，指定fallback类
 * 
 * @author eacdy
 */
@FeignClient(name = "microservice-provider-user01", fallback = FeignHystrixFallback.class)
public interface UserFeignHystrixClient01 {
	
	@RequestMapping("/{id}")
	public User findById(@RequestParam("id") Long id);

	
}
