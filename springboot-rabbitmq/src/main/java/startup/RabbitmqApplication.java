package startup;

import javax.annotation.Resource;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import produer.RabbitmqProducer;

@SpringBootApplication
@ComponentScan(basePackages = "controller,produer,consumer")
public class RabbitmqApplication implements ApplicationRunner {
	
    public static void main(String[] args) {
        SpringApplication.run(RabbitmqApplication.class, args);
    }
    
    @Resource
    private RabbitmqProducer rabbitmqProducer;

    @Override
    public void run(ApplicationArguments args) throws Exception {
    	rabbitmqProducer.sendMessage();
    }
    
}
