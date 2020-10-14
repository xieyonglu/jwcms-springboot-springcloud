package service;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class HelloService {

	private String msg;

	private String name;

	public String sayHello() {
		return name + " say " + msg + " !";
	}
}