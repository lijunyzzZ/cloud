package org.lijuny.springcloud.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.lijuny.springcloud.dao.OrderDao;
import org.lijuny.springcloud.domain.Order;
import org.lijuny.springcloud.entities.CommonResult;
import org.lijuny.springcloud.service.AccountFeignService;
import org.lijuny.springcloud.service.OrderService;
import org.lijuny.springcloud.service.StorageFeignClient;
import org.springframework.stereotype.Service;

import io.seata.spring.annotation.GlobalTransactional;

/**
 * @author lijunyi
 */
@Service
public class OrderServiceImpl implements OrderService {

	private final OrderDao dao;
	private final AccountFeignService accountFeignService;
	private final StorageFeignClient storageFeignClient;
	public OrderServiceImpl(OrderDao dao, AccountFeignService accountFeignService, StorageFeignClient storageFeignClient) {
		this.dao = dao;
		this.accountFeignService = accountFeignService;
		this.storageFeignClient = storageFeignClient;
	}

	@Override
	@GlobalTransactional(rollbackFor = Exception.class,name = "fsp-create-order")
	public void create(Order order) {
		this.dao.create(order);
		Map<String, Object> map = new HashMap<>();
		map.put("id", order.getId());
		map.put("money", order.getMoney());
		CommonResult consumer = accountFeignService.consumer(map);
		System.out.println(consumer);
		storageFeignClient.decrease(order.getId(), order.getCount());

	}
}
