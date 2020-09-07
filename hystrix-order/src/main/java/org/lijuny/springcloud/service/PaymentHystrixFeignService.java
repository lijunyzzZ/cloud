package org.lijuny.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author lijunyi
 */
@Component
@FeignClient(value = "hystrix-payment", fallback = PaymentFallService.class)
public interface PaymentHystrixFeignService {
	@GetMapping("/hystrix/payment/ok/{id}")
	String payment_ok(@PathVariable("id") Integer id);
	@GetMapping("/hystrix/payment/error/{id}")
	String payment_error(@PathVariable("id") Integer id) ;
}
