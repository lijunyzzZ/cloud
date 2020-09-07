package org.lijuny.springcloud.controller;

import java.util.Map;

import org.lijuny.springcloud.domain.Order;
import org.lijuny.springcloud.entities.CommonResult;
import org.lijuny.springcloud.service.OrderService;
import org.springframework.web.bind.annotation.*;

import cn.hutool.core.map.MapUtil;

/**
 * @author lijunyi
 */
@RestController
public class OrderController {
	private final OrderService orderService;

	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}

	@RequestMapping("/order/create")
	public CommonResult create(@RequestBody Map<String, Object> map) {
		Integer id = MapUtil.getInt(map, "id");
		String user_id = MapUtil.getStr(map, "user_id");
		String commodity_code = MapUtil.getStr(map, "commodity_code");
		Integer count = MapUtil.getInt(map, "count");
		Integer money = MapUtil.getInt(map, "money");
		Order order = new Order(id, user_id, commodity_code, count, money);
		this.orderService.create(order);
		return new CommonResult(200, "创建订单成功");
	}
}
