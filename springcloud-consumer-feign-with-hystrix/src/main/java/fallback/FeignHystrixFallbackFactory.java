package fallback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import client.UserFeignHystrixClient02;
import feign.hystrix.FallbackFactory;
import model.User;

@Component
public class FeignHystrixFallbackFactory implements FallbackFactory<UserFeignHystrixClient02> {

	private static final Logger LOGGER = LoggerFactory.getLogger(FeignHystrixFallbackFactory.class);
	
    @Override
    public UserFeignHystrixClient02 create(Throwable cause) {
        return new UserFeignHystrixClient02() {

			@Override
			public User findById(Long id) {
				FeignHystrixFallbackFactory.LOGGER.info("异常发生，进入fallback方法，接收的参数：id = {}", id);
				User user = new User();
				user.setId(-1L);
				user.setUsername("default username 02");
				user.setAge(0);
				return user;
			}
        };
    }

}