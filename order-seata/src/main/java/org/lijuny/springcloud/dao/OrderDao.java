package org.lijuny.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.lijuny.springcloud.domain.Order;
import org.springframework.stereotype.Repository;

/**
 * @author lijunyi
 */
@Mapper
@Repository
public interface OrderDao {
	void create(@Param("order")Order order);
}
