package org.lijuny.springcloud.service;


import org.lijuny.springcloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("seata-storage-service")
public interface StorageFeignClient {

	@RequestMapping("/storage/decrease")
	public CommonResult decrease(@RequestParam("id") Integer id, @RequestParam("count") Integer count);
}
