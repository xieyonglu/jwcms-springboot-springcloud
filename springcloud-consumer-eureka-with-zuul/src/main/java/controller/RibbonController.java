package controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/user-service")
public class RibbonController {

	@GetMapping("/user/find_by_id/{id}")
	public Long findById(@PathVariable Long id) {
		System.out.println("=====>>>>" + id);
		return id;
	}
	
	@GetMapping("/user/find_by_id2/{id}")
	public Long findById2(@PathVariable Long id) {
		System.out.println("=====>>>>" + id);
		return id;
	}
}
