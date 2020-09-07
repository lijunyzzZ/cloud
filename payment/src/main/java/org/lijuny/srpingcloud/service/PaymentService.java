package org.lijuny.srpingcloud.service;

import org.apache.ibatis.annotations.Param;
import org.lijuny.springcloud.entities.Payment;

public interface PaymentService {
	Payment getPaymentById(@Param("id") Long id);

	int create(Payment payment);
}
