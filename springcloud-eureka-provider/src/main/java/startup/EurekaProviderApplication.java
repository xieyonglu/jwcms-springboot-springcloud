package startup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = "controller")
public class EurekaProviderApplication {
	
    public static void main(String[] args) {
        SpringApplication.run(EurekaProviderApplication.class, args);
    }
    
}
