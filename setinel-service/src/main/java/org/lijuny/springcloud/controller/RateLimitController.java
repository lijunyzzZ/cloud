package org.lijuny.springcloud.controller;

import org.lijuny.springcloud.entities.CommonResult;
import org.lijuny.springcloud.entities.Payment;
import org.lijuny.springcloud.myhandlee.CustomHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * @author lijunyi
 */
@RestController
public class RateLimitController {
	@GetMapping("/byResource")
	@SentinelResource(value = "byResource", blockHandlerClass = CustomHandler.class, blockHandler = "handler")
	public CommonResult byResource() {
		return new CommonResult(200, "按资源名称限流测试OK", new Payment(2020L, "serial001"));
	}

	public CommonResult handle(BlockException e) {
		return new CommonResult(444, e.getClass().getCanonicalName() + "\t 服务不可用");
	}
}
