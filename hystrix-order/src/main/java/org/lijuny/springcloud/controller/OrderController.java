package org.lijuny.springcloud.controller;

import org.lijuny.springcloud.service.PaymentHystrixFeignService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import lombok.extern.slf4j.Slf4j;

/**
 * @author lijunyi
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "globalPaymentTimeoutFallback")
public class OrderController {
	private final PaymentHystrixFeignService paymentFeignService;

	public OrderController( PaymentHystrixFeignService paymentFeignService) {
		this.paymentFeignService = paymentFeignService;
	}

	@GetMapping("/hystrix/order/ok/{id}")
	public String payment_ok(@PathVariable Integer id) {
		return paymentFeignService.payment_ok(id);
	}
	@GetMapping("/hystrix/order/error/{id}")
//	@HystrixCommand(fallbackMethod = "paymentTimeoutFallback", commandProperties = {
//			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
//	})
	@HystrixCommand
	public String payment_error(@PathVariable Integer id) {
		log.error("error invoke");
		int a  =10/0;
		return paymentFeignService.payment_error(id);
	}

	public String paymentTimeoutFallback(Integer id) {
		return "80 global fallback" + id;
	}

	public String globalPaymentTimeoutFallback() {
		return "80 global fallback";
	}
}
