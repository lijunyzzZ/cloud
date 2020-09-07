package org.lijuny.springcloud.controller;

import org.lijuny.springcloud.servier.MessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author lijunyi
 */
@RestController
public class MessageController {

	@Resource
	private MessageProvider messageProvider;

	@GetMapping("/sendMessage")
	public String send() {
		return messageProvider.send();
	}
}
