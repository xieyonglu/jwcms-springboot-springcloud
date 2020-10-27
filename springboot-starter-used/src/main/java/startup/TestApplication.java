package startup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import service.HelloService;

@SpringBootApplication
//@EnableDemoConfiguration
public class TestApplication {

	@Autowired
	HelloService helloService;

	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}

//	@PostConstruct
	public void test() {
		helloService.sayHello();
	}

}
