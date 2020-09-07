package org.lijuny.springcloud.service;

import org.lijuny.springcloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient("cloud-provider-payment") // 这里写服务名
public interface PaymentFeignService {
	@GetMapping("/payment/port")
	public String port();
	@GetMapping("/payment/getPaymentById/{id}")
	public CommonResult<?> getPaymentById(@PathVariable("id") Long id);
	@GetMapping("/payment/timeout")
	public String getPort();
}
