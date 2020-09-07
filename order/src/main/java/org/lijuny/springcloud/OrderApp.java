package org.lijuny.springcloud;

import org.lijuny.myrule.MyRuleConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClientName;

/**
 * @author lijunyi
 */
@SpringBootApplication
@EnableDiscoveryClient
//@RibbonClient(name = "cloud-provider-payment", configuration = MyRuleConfig.class)
public class OrderApp {

	public static void main(String[] args) {
		SpringApplication.run(OrderApp.class, args);
	}
}
