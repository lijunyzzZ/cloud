package org.lijuny.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author lijunyi
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigServerApp {
	public static void main(String[] args) {
		SpringApplication.run(ConfigServerApp.class, args);
	}
}
