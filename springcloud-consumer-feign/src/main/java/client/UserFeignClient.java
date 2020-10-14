package client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import model.User;

/**
 * 编写feign的接口 user-client，注册中心注册的应用名
 */
@FeignClient(value = "microservice-provider-user")
public interface UserFeignClient {
	
    /**
     * @PathVariable("id")这里面必须写"id"不然注入不了这个UserFeignClient
     * @param id
     * @return
     * /userclient/user/{id}，是服务器需要调用的服务器的资源路径
     */
    @GetMapping("/{id}")
    User queryById(@PathVariable("id") Long id);
    
}
