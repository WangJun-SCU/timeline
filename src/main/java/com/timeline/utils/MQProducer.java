package com.timeline.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

import com.timeline.common.Constants;

/**
 * @author wangjun
 * @date 2019-01-04
 * @version 1.0
 */
public class MQProducer {

	private static final Logger logger = LogManager.getLogger(MQProducer.class);

	/*
	 * 同步生产消息
	 */
	public void syncProducer() throws Exception {
		logger.debug("生产者生产同步消息.");
		
		// 使用生产者组名初始化一个生产者
		DefaultMQProducer producer = new DefaultMQProducer(Constants.MQ_GROUP_NAME);
		// 指定name server的地址
		producer.setNamesrvAddr(Constants.MQ_NAMESERVER_ADDRESS);
		// 启动实例
		producer.start();

		for (int i = 0; i < 5; i++) {
			Message msg = new Message("TopicTest", "TagA",("Hello RocketMQ " + i).getBytes(RemotingHelper.DEFAULT_CHARSET));
			SendResult sendResult = producer.send(msg);
			logger.info("生产者同步生产的消息:{}", sendResult.toString());
		}

		// 及时关闭生产者
		producer.shutdown();
	}

	/*
	 * 异步生产消息
	 */
	public void asyncProducer() throws Exception {
		logger.debug("生产者生产异步消息.");
		
		DefaultMQProducer producer = new DefaultMQProducer(Constants.MQ_GROUP_NAME);
		producer.setNamesrvAddr(Constants.MQ_NAMESERVER_ADDRESS);
		producer.start();
		producer.setRetryTimesWhenSendAsyncFailed(0);

		for (int i = 0; i < 5; i++) {
			final int index = i;
			Message msg = new Message("TopicTest", "TagA", "OrderID188", "Hello world".getBytes(RemotingHelper.DEFAULT_CHARSET));
			producer.send(msg, new SendCallback() {
				@Override
				public void onSuccess(SendResult sendResult) {
					logger.info("index:" + index + "msgId:" + sendResult.getMsgId());
				}

				@Override
				public void onException(Throwable e) {
					logger.error("index:" + index + e.toString());
					e.printStackTrace();
				}
			});
		}
		
		producer.shutdown();
	}
	
	/*
	 * 单向生产消息
	 */
	public void oneWayProducer() throws Exception {
		logger.debug("生产者生产单向消息.");
		
        DefaultMQProducer producer = new DefaultMQProducer(Constants.MQ_GROUP_NAME);
        producer.setNamesrvAddr(Constants.MQ_NAMESERVER_ADDRESS);
        producer.start();
        
        for (int i = 0; i < 5; i++) {
            Message msg = new Message("TopicTest", "TagA", ("Hello RocketMQ " + i).getBytes(RemotingHelper.DEFAULT_CHARSET));
            producer.sendOneway(msg);
            logger.info("生产者单向生产的消息:" + msg.toString());
        }
        
        producer.shutdown();
	}
}
