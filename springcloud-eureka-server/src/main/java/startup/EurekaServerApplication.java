package startup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
//创建服务注册中心
@EnableEurekaServer
public class EurekaServerApplication {
	
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class, args);
    }
    
}
