package org.lijuny.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author lijunyi
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class HystrixOrderApp {
	public static void main(String[] args) {
		SpringApplication.run(HystrixOrderApp.class, args);
	}
}
