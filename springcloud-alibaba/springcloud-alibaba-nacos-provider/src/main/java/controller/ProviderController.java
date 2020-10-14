package controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderController {

	@GetMapping("/{id}")
	public User findById(@PathVariable Long id) throws Exception {
		User user = new User();
		user.setId(1000L);
		user.setAge(30);
		user.setUsername("xieyonglu");
		
		return user;
	}
}
