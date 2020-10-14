package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import model.User;

@Service
public class RibbonService {
	
	private static final String SPRINGCLOUD_EUREKA_PROVIDER = "springcloud-eureka-provider";

	@Autowired
	private RestTemplate restTemplate;
	public User findById(Long id) {
		// http://服务提供者的serviceId/url
		return this.restTemplate.getForObject("http://" + SPRINGCLOUD_EUREKA_PROVIDER + "/" + id, User.class);
	}
	

	@Autowired
	private LoadBalancerClient loadBalancerClient;
	public void printLog() {
		ServiceInstance instance = loadBalancerClient.choose(SPRINGCLOUD_EUREKA_PROVIDER);
		System.out.println("Now:" + instance.getServiceId() + "---" + instance.getHost() + ":" + instance.getPort());
	}
	

	@Autowired
	private DiscoveryClient discoveryClient;
	public List<ServiceInstance> showInfo() {
		return discoveryClient.getInstances("service-provider-user");
	}

}
