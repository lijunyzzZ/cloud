package org.lijuny.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lijunyi
 */
@Configuration
public class MyRuleConfig {
	@Bean
	public IRule myRule() {
		return new RandomRule();
	}
}
