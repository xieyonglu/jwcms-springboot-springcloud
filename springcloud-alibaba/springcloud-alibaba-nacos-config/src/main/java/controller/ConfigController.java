package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ConfigController {
	
	@Autowired
	private ConfigurableApplicationContext applicationContext;

	@GetMapping(value = "/hello")
	public String hello() {
	    return "Hello " + applicationContext.getEnvironment().getProperty("user.name");
	}
	
}
