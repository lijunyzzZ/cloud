package org.lijuny.springcloud.controller;

import org.lijuny.springcloud.entities.CommonResult;
import org.lijuny.springcloud.service.PaymentFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lijunyi
 */
@RestController
public class OpenFeignController {

	final
	PaymentFeignService service;

	public OpenFeignController(PaymentFeignService service) {
		this.service = service;
	}

	@GetMapping("/order/port")
	public String port() {
		return service.port();
	}

	@GetMapping("/order/timeout")
	public String getPort() {
		return service.getPort();
	}
}
