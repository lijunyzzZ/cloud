package org.lijuny.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author lijunyi
 */
@SpringBootApplication
@EnableFeignClients
public class OpenFeignApp {
	public static void main(String[] args) {
		SpringApplication.run(OpenFeignApp.class, args);
	}
}
