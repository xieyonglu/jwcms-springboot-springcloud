package config;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;

public class MySentinelResource {

	@SentinelResource(value = "message", blockHandler = "blockHandler", fallback = "fallback")
	public String message(String str) {
		if (StringUtils.isBlank(str)) {
			throw new RuntimeException();
		}
		return str;
	}

	/**
	 * 限流处理
	 * 
	 * @param str
	 * @param ex
	 * @return
	 */
	public String blockHandler(String str, BlockException ex) {
		return str + "--" + ex;
	}

	/**
	 * 降级处理
	 * 
	 * @param str
	 * @return
	 */
	public String fallback(String str) {
		return null;
	}
}