package org.lijuny.springcloud.filter;

import java.util.Date;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

/**
 * @author lijunyi
 */
@Component
@Slf4j
public class LogFilter  implements GlobalFilter, Ordered {
	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		log.info("come in Filter:" + new Date());
		String uname = exchange.getRequest().getQueryParams().getFirst("uname");
		if (uname == null) {
			log.info("uname must be not empty");
			exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
			return exchange.getResponse().setComplete();
		}
		return chain.filter(exchange);
	}

	@Override
	public int getOrder() {
		return 0;
	}
}
