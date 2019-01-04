package com.timeline.utils;
/**
 * @author wangjun
 * @date 2019-01-04
 * @version 1.0
 */

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import com.timeline.common.Constants;

public class MQConsumer implements ApplicationListener<ContextRefreshedEvent> {
	
	private static final Logger logger = LogManager.getLogger(MQConsumer.class);

	public void consume() throws InterruptedException, MQClientException {
		DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(Constants.MQ_GROUP_NAME);
		consumer.setNamesrvAddr(Constants.MQ_NAMESERVER_ADDRESS);
		//消费指定的topic
		consumer.subscribe("TopicTest", "*");
		
		//注册消费者回调函数
		consumer.registerMessageListener(new MessageListenerConcurrently() {

			@Override
			public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
				logger.info("消费的消息条数:" + msgs.size());
				for(MessageExt msg: msgs) {
					logger.info("消费的消息:" + msg.toString());
				}
				return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
			}
		});

		consumer.start();
		logger.info("Consumer Started...");
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		try {
			consume();
		} catch(Exception e) {
			logger.error("start mqConsumer failed!" + e.toString());
		}
	}

}
