package org.lijuny.springcloud.service;

import java.util.Map;

import org.lijuny.springcloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author lijunyi
 */
@FeignClient("seata-account-service")
public interface AccountFeignService {

	@PostMapping("/account/decrease")
	CommonResult consumer(@RequestBody Map<String,Object> map);
}
