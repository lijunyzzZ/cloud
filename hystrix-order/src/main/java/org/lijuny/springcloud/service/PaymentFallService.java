package org.lijuny.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author lijunyi
 */
@Component
public class PaymentFallService implements PaymentHystrixFeignService {
	@Override
	public String payment_ok(Integer id) {
		return "PaymentFallService : payment_ok";
	}

	@Override
	public String payment_error(Integer id) {
		return "PaymentFallService : payment_error";
	}
}
