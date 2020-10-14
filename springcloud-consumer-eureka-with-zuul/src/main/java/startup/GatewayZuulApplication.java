package startup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableZuulProxy
@ComponentScan(basePackages = "controller")
public class GatewayZuulApplication {
 
    public static void main(String[] args) {
        SpringApplication.run(GatewayZuulApplication.class, args);
    }
}