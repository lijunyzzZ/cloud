package org.lijuny.springcloud.controller.loadBlance.impl;

import cn.hutool.core.collection.CollectionUtil;
import org.lijuny.springcloud.controller.loadBlance.MyLoadBalance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author lijunyi
 */
@Component
public class MyLoadBalanceImpl implements MyLoadBalance {
	private final DiscoveryClient client;

	private final AtomicInteger current = new AtomicInteger();
	public MyLoadBalanceImpl(DiscoveryClient client) {
		this.client = client;
	}

	@Override
	public ServiceInstance getInstance(String serverName) {
		List<ServiceInstance> instances = client.getInstances(serverName);
		if (CollectionUtil.isEmpty(instances)) {
			return null;
		}
		int next = getAndIncrement();
		return instances.get(next % instances.size());
	}

	private int getAndIncrement() {
		for (; ; ) {
			int currentIndex = current.get();
			int next = currentIndex == Integer.MAX_VALUE? 0:currentIndex+1;
			if (current.compareAndSet(currentIndex, next)) {
				return next;
			}
		}
	}
}
