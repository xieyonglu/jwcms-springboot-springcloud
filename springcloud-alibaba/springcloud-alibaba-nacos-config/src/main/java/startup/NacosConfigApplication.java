package startup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = "controller")
public class NacosConfigApplication {
	
    public static void main(String[] args) {
        SpringApplication.run(NacosConfigApplication.class, args);
    }
    
}
