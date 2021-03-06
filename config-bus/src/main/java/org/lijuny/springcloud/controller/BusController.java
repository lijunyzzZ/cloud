package org.lijuny.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lijunyi
 */
@RestController
@RefreshScope
public class BusController {

	@Value("${server.port}")
	private String port;

	@Value("${config.info}")
	private String configInfo;

	@GetMapping("/configInfo")
	public String configInfo() {
		return "serverPort: [" + port + "\n" + configInfo;
	}
}
