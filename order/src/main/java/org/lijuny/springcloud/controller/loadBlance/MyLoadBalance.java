package org.lijuny.springcloud.controller.loadBlance;

import org.springframework.cloud.client.ServiceInstance;

public interface MyLoadBalance {
	ServiceInstance getInstance(String serverName);
}
