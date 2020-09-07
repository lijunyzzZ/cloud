package org.lijuny.springcloud.controller;

import org.lijuny.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

/**
 * @author lijunyi
 */
@RestController
@Slf4j
public class PaymentController {

	private final PaymentService paymentService;

	public PaymentController(PaymentService paymentService) {
		this.paymentService = paymentService;
	}

	@Value("${server.port}")
	private String port;

	@GetMapping("/hystrix/payment/ok/{id}")
	public String payment_ok(@PathVariable Integer id) {
		return paymentService.paymentInfo_ok(id);
	}
	@GetMapping("/hystrix/payment/error/{id}")
	public String payment_error(@PathVariable Integer id) {
		log.error("error invoke");
		return paymentService.paymentInfo_TimeOut(id);
	}

	@GetMapping("/hystrix/circuit/{id}")
	public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
		return paymentService.paymentCircuitBreaker(id);
	}
}
