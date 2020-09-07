package org.lijuny.srpingcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.lijuny.springcloud.entities.Payment;
import org.springframework.stereotype.Repository;

/**
 * @author lijunyi
 */
@Mapper
@Repository
public interface PaymentDao {
	Payment getPaymentById(@Param("id") Long id);

	int create(Payment payment);
}
