package org.lijuny.springcloud.servier.impl;

import java.util.UUID;

import org.lijuny.springcloud.servier.MessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;

/**
 * @author lijunyi
 */
@EnableBinding(Source.class) //发送管道
public class MessageProviderImpl implements MessageProvider {
	@Resource
	private MessageChannel output;

	@Override
	public String send() {
		String payload = UUID.randomUUID().toString();
		output.send(MessageBuilder.withPayload(payload).build());
		return null;
	}
}
