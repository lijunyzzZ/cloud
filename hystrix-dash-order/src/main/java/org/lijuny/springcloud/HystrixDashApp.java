package org.lijuny.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author lijunyi
 */
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashApp {
	public static void main(String[] args) {
		SpringApplication.run(HystrixDashApp.class, args);
	}
}
