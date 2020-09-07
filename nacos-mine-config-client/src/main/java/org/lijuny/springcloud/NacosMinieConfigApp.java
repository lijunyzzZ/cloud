package org.lijuny.springcloud;

import java.util.concurrent.TimeUnit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author lijunyi
 */
@SpringBootApplication
public class NacosMinieConfigApp {
	public static void main(String[] args) throws InterruptedException {
		ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(NacosMinieConfigApp.class, args);
		while (true) {
			String userName = configurableApplicationContext.getEnvironment().getProperty("user.name");
			String userAge = configurableApplicationContext.getEnvironment().getProperty("user.age");
			String refersh = configurableApplicationContext.getEnvironment().getProperty("user.refersh");
			System.err.println("userName: [" + userName + "], userAge: [" + userAge + "], refresh: [" + refersh + "]");
			TimeUnit.SECONDS.sleep(1);
		}


	}
}
