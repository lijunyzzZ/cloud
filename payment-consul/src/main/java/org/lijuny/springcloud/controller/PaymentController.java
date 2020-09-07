package org.lijuny.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author lijunyi
 */
@RestController
public class PaymentController {
	@Value("${server.port}")
	private int port;

	@GetMapping("/payment/consul")
	public String paymentConsul(){
		return "consul" + port + UUID.randomUUID().toString();
	}
}
