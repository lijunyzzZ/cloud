package org.lijuny.springcloud.controller;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;

import ch.qos.logback.core.util.TimeUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * @author lijunyi
 */
@RestController
@Slf4j
public class FlowController {
	private final RestTemplate restTemplate;

	public FlowController(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@GetMapping("/testA")
	public String testA() throws InterruptedException {
		return "------testA";
	}

	@GetMapping("/testB")
	public String testB() {
		return restTemplate.getForObject("http://localhost:8401/testA", String.class);

//		log.info(Thread.currentThread().getName() + "\t" + "...testB");
//		return "------testB";
	}
	@GetMapping("/testC")//RT
	public String testC() throws InterruptedException {
		TimeUnit.SECONDS.sleep(1);
		return "-----testC";
	}
	@GetMapping("/testD")
	public String testD() {
		System.out.println("测试异常比例");
		throw new RuntimeException();
	}

	@GetMapping("/testHotKey")
	@SentinelResource(value = "testHotKey", blockHandler = "handle")
	public String testHotKey(@RequestParam(value = "p1", required = false) String p1,
	                         @RequestParam(value = "p2", required = false) String p2) {
		return "testHotKey";
	}

	public String handle(String p1, String p2, BlockException e) {
		return "block" + p1 + p2 + e.getMessage();
	}
}
