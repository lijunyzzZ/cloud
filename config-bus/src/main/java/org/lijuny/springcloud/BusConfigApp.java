package org.lijuny.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author lijunyi
 */
@SpringBootApplication
@EnableEurekaClient
public class BusConfigApp {
	public static void main(String[] args) {
		SpringApplication.run(BusConfigApp.class, args);
	}
}
