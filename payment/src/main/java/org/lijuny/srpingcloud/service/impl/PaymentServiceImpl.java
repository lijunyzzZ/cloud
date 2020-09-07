package org.lijuny.srpingcloud.service.impl;

import org.lijuny.springcloud.entities.Payment;
import org.lijuny.srpingcloud.dao.PaymentDao;
import org.lijuny.srpingcloud.service.PaymentService;
import org.springframework.stereotype.Service;

/**
 * @author lijunyi
 */
@Service
public class PaymentServiceImpl implements PaymentService {

	private final PaymentDao dao;

	public PaymentServiceImpl(PaymentDao dao) {
		this.dao = dao;
	}

	@Override
	public Payment getPaymentById(Long id) {
		return dao.getPaymentById(id);
	}

	@Override
	public int create(Payment payment) {
		return dao.create(payment);
	}
}
