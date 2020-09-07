package org.lijuny.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author lijunyi
 */
@Configuration
@MapperScan({"org.lijuny.springcloud.dao"})
public class MyBatisConfig {

}
