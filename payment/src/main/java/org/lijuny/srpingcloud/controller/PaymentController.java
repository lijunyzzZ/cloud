package org.lijuny.srpingcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.lijuny.springcloud.entities.CommonResult;
import org.lijuny.springcloud.entities.Payment;
import org.lijuny.srpingcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author lijunyi
 */
@RestController
@Slf4j
public class PaymentController {

	private final PaymentService paymentService;

	@Value("${server.port}")
	private String port;

	public PaymentController(PaymentService paymentService, DiscoveryClient discoveryClient) {
		this.paymentService = paymentService;
		this.discoveryClient = discoveryClient;
	}

	@PostMapping("/payment/create")
	public CommonResult<?> create(@RequestBody Payment payment) {
		int result = paymentService.create(payment);
		log.info("insert res " + result);
		if (result > 0) {
			return new CommonResult<>(200, getMessage("插入数据库成功"), result);
		}
		return new CommonResult<>(444, getMessage("插入失败"));
	}

	@GetMapping("/payment/getPaymentById/{id}")
	public CommonResult<?> getPaymentById(@PathVariable("id") Long id) {
		Payment result = paymentService.getPaymentById(id);
		log.info("get res ： " + result);
		if (result != null) {
			return new CommonResult<>(200, getMessage(" 查询成功"), result);
		}
		return new CommonResult<>(444, getMessage("查询失败，id为") + id);
	}

	private String getMessage(String msg) {
		return "port:[" + port + ']' + msg;

	}

	private final DiscoveryClient discoveryClient;
	@GetMapping("/payment/discovery")
	public Object discovery() {
		return discoveryClient.getServices();
	}

	@GetMapping("/payment/discovery/{service}")
	public Object getService(@PathVariable String service) {
		return discoveryClient.getInstances(service);
	}
	@GetMapping("/payment/client")
	public Object getClient() {
		return discoveryClient;
	}
	@GetMapping("/payment/port")
	public String port() {
		return port;
	}
	@GetMapping("/payment/timeout")
	public String getPort() {
		try {
			TimeUnit.SECONDS.sleep(6);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return port;
	}

	@GetMapping("/payment/zipkin")
	public String paymentZipkin() {
		return "hi , I'am paymentZipkin server fall back, fuck";
	}

}
