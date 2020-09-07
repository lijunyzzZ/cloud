package org.lijuny.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.csp.sentinel.annotation.SentinelResource;

/**
 * @author lijunyi
 */
@RestController
public class HelloController {
	@GetMapping(value = "/hello")
	@SentinelResource(value = "hello", fallback = "fallback", blockHandler = "blockHandler", blockHandlerClass = HelloController.class)
	public String hello() {
		if (true) {
			throw new RuntimeException();
		}
		return "Hello Sentinel";
	}

	public String blockHandler() {
		return "blockHandler";
	}

	public String fallback() {
		return "fallback";
	}
}
