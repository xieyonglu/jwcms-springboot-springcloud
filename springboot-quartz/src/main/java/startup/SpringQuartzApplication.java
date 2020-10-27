package startup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
@ComponentScan(basePackages = "config")
public class SpringQuartzApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringQuartzApplication.class, args);
	}
}
