package org.lijuny.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;

/**
 * @author lijunyi
 */
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class HystrixPaymentApp {
	public static void main(String[] args) {
		SpringApplication.run(HystrixPaymentApp.class, args);
	}

	@Bean
	public ServletRegistrationBean<HystrixMetricsStreamServlet> getServlet() {
		HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
		ServletRegistrationBean<HystrixMetricsStreamServlet> bean = new ServletRegistrationBean<>(streamServlet);
		bean.setLoadOnStartup(1);
		bean.addUrlMappings("/hystrix.stream");
		bean.setName("HystrixMetricsStreamServlet");
		return bean;
	}
}
