package org.lijuny.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

/**
 * @author lijunyi
 */
@RestController
@Slf4j
public class NacosController {
	private final LoadBalancerClient client;

	private final RestTemplate restTemplate;

	@Value("${spring.application.name}")
	private String appName;

	public NacosController(LoadBalancerClient client, RestTemplate restTemplate) {
		this.client = client;
		this.restTemplate = restTemplate;
	}

	@GetMapping("/echo/app-name")
	public String echoAppName() {
		return restTemplate.getForObject("http://nacos-mine-provider/echo/"  +appName, String.class);
	}
}
