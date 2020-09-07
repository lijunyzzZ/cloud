package org.lijuny.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lijunyi
 */
@Configuration
public class GateWayConfig {

	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocator) {
		RouteLocatorBuilder.Builder routes = routeLocator.routes();
		routes.route("path_out", r -> r.path("/out").uri("http://www.baidu.com")).build();
		return routes.build();
	}
}
