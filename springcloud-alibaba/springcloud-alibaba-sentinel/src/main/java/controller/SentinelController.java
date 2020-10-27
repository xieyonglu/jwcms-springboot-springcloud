package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;

import service.SentinelService;

@RestController
public class SentinelController {

	@GetMapping("/test")
	public String test() {
		return "hello! sentinel!";
	}
	
	@Autowired
    private SentinelService sentinelService;

	@GetMapping("/query")
    @ResponseBody
    public String query(@RequestParam("spuId") String spuId) {
        return sentinelService.queryGoodsInfo(spuId);
    }

	@GetMapping("/test1")
	public String test1(String name, Integer age) {
		Entry entry = null;
		try {
			entry = SphU.entry("HelloWorld");
			/* 您的业务逻辑 - 开始 */
			Thread.sleep(3000L);
			System.out.println("hello world");
			/* 您的业务逻辑 - 结束 */
		} catch (BlockException | InterruptedException e1) {
			/* 流控逻辑处理 - 开始 */
			System.out.println("block!");
			/* 流控逻辑处理 - 结束 */
		} finally {
			if (entry != null) {
				entry.exit();
			}
		}

		return "hello! sentinel!" + name + age;
	}

	@SentinelResource("test2")
	@GetMapping("/myTest")
	public String test2(String name, Integer age) {
		return "hello! sentinel!" + name + age;
	}

}
