package org.lijuny.springcloud.server;

import org.lijuny.springcloud.entities.CommonResult;
import org.lijuny.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author lijunyi
 */
@Repository
@FeignClient(value = "nacos-payment-provider",fallback = PaymentFallbackService.class)
public interface PaymentService
{
	@GetMapping(value = "/paymentSQL/{id}")
	public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id);
}