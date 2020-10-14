package controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {
	
	@Resource
    private RestTemplate restTemplate;
	
	//也可以将这个地址写在类中
    @Value("${service-url.nacos-user-service}")
    private String serverURL;
	
	@GetMapping("/{id}")
	public User findById(@PathVariable Long id) throws Exception {
		return restTemplate.getForObject(serverURL + "/" + id, User.class);
	}
}
