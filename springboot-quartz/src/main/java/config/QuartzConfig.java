package config;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class QuartzConfig {

	// 每隔五秒
	@Scheduled(cron = "0/5 * * * * ? ")
	public void process() {
		System.out.println("我是定时任务！");
	}
}
