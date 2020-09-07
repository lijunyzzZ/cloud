package org.lijuny.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author lijunyi
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class SeataOrderApp {
	public static void main(String[] args) {
		SpringApplication.run(SeataOrderApp.class, args);
	}
}
