package org.lijuny.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author lijunyi
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SentinelServiceApp {
	public static void main(String[] args) {
		SpringApplication.run(SentinelServiceApp.class, args);
	}
}
