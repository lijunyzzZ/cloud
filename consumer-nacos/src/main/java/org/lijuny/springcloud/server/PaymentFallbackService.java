package org.lijuny.springcloud.server;

import org.lijuny.springcloud.entities.CommonResult;
import org.lijuny.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * @author lijunyi
 */
@Component
public class PaymentFallbackService implements PaymentService{
	@Override
	public CommonResult<Payment> paymentSQL(Long id)
	{
		return new CommonResult<>(44444,"服务降级返回,---PaymentFallbackService",new Payment(id,"errorSerial"));
	}
}
