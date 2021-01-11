package controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@Value("${server.port}")
	private String serverPort;

	@GetMapping(value = "/test")
	public String test() throws Exception {
		return "Hello World ==> " + serverPort;
	}

}
