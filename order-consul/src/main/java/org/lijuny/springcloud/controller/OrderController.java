package org.lijuny.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author lijunyi
 */
@RestController
public class OrderController {
	private final RestTemplate restTemplate;

	public OrderController(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	public static final String URL = "http://consul-payment";

	@GetMapping("/orderConsul/get")
	public String  orderConsul() {
		return restTemplate.getForObject(URL + "/payment/consul", String.class);
	}
}
