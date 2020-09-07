package org.lijuny.springcloud.controller;

import org.lijuny.springcloud.entities.CommonResult;
import org.lijuny.springcloud.service.impl.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lijunyi
 */
@RestController
public class StorageController {
	@Autowired
	private StorageService service;

	@RequestMapping("/storage/decrease")
	public CommonResult decrease(@RequestParam("id") Integer id,@RequestParam("count") Integer count) {
		service.decrease(id, count);
		return new CommonResult(200, "扣库存成功");
	}
}
