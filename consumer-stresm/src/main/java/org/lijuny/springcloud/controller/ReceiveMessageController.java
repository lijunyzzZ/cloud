package org.lijuny.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @author lijunyi
 */
@Component
@EnableBinding(Sink.class)
public class ReceiveMessageController {
	@Value("${server.port}")
	private String serverPort;

	@StreamListener(Sink.INPUT)
	public void input(Message<String> mes) {
		System.out.println("消费者：[" + serverPort + "]收到消息 :" + mes.getPayload());
	}
}
