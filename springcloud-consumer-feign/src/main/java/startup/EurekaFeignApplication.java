package startup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @EnableFeignClients("cn.learn.springcloud.feignclient")主配置类开启fenign
 */
@SpringBootApplication
@EnableFeignClients("client")
@ComponentScan(basePackages = "controller")
@EnableDiscoveryClient
public class EurekaFeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaFeignApplication.class, args);
	}

}
