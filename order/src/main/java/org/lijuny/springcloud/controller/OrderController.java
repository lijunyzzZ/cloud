package org.lijuny.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.lijuny.springcloud.controller.loadBlance.MyLoadBalance;
import org.lijuny.springcloud.entities.CommonResult;
import org.lijuny.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

/**
 * @author lijunyi
 */
@RestController
@Slf4j
public class OrderController {
	private final RestTemplate restTemplate;

	private final DiscoveryClient client;

	private final MyLoadBalance myLoadBalance;

	public static final String PAYMENT_URL = "http://cloud-provider-payment";

	public OrderController(RestTemplate restTemplate, DiscoveryClient client, MyLoadBalance myLoadBalance) {
		this.restTemplate = restTemplate;
		this.client = client;
		this.myLoadBalance = myLoadBalance;
	}

	@GetMapping("/order/payment/create")
	public CommonResult<?> create(Payment payment) {
		return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
	}

	@GetMapping("/order/payment/get/{id}")
	public CommonResult<?> getPayment(@PathVariable("id") Long id) {
		return restTemplate.getForObject(PAYMENT_URL + "/payment/getPaymentById/" + id, CommonResult.class);
	}

	@GetMapping("/order/payment/getEntity/{id}")
	public CommonResult<?> getPaymentForEntity(@PathVariable("id") Long id) {
		ResponseEntity<CommonResult> forEntity = restTemplate.getForEntity(PAYMENT_URL + "/payment/getPaymentById/" + id, CommonResult.class);
		if (forEntity.getStatusCode().is2xxSuccessful()) {
			return forEntity.getBody();
		} else {
			return new CommonResult<>(444,"出错了");
		}
	}

	@GetMapping("/order/payment/port")
	public Object OrderPort() {
		ServiceInstance instance = myLoadBalance.getInstance("cloud-provider-payment");
		if (instance == null) {
			return new CommonResult<>(444, "找不到服务实例");
		}
		URI uri = instance.getUri();
		return restTemplate.getForObject(uri + "/payment/port", String.class);
	}


	@GetMapping("/order/zipkin")
	public String paymentZipkin() {
		return restTemplate.getForObject("http://localhost:8001/payment/zipkin", String.class);
	}
}
