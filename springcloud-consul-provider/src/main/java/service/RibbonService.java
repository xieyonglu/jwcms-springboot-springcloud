package service;

import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;

import model.User;

@Service 
public class RibbonService { 
	
//	@Autowired 
//	private RestTemplate restTemplate; 
	
	public User findById(Long id) { 
		// http://服务提供者的serviceId/url 
//		return this.restTemplate.getForObject("http://MICROSERVICE-PROVIDER-USER/" + id, User.class);
		User user = new User();
		user.setId(1000L);
		user.setUsername("xieyonglu");
		user.setAge(18);
		return user;
	}
}
