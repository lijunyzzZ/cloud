package org.lijuny.springcloud.controller;

import java.util.Map;

import org.lijuny.springcloud.entities.CommonResult;
import org.lijuny.springcloud.service.AccountService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cn.hutool.core.map.MapUtil;

/**
 * @author lijunyi
 */
@RestController
public class AccountController {

	private final AccountService accountService;

	public AccountController(AccountService accountService) {
		this.accountService = accountService;
	}

	@PostMapping("/account/decrease")
	public CommonResult consumer(@RequestBody Map<String,Object> map) {
		Integer id = MapUtil.getInt(map, "id");
		Integer money = MapUtil.getInt(map, "money");
		accountService.decreaseMoney(money, id);
		return new CommonResult(200, "修改用户金额正确");
	}
}
