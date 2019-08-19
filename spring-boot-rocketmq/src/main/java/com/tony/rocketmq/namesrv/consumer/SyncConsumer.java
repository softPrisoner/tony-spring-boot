package com.tony.rocketmq.namesrv.consumer;

import com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.common.message.MessageExt;

/**
 * @author tony
 * @describe SyncConsumer
 * @date 2019-08-19
 */
public class SyncConsumer {
    public static void main(String[] args) throws MQClientException {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("order-group");
        consumer.setNamesrvAddr("localhost:9876");
        consumer.subscribe("orderTopic", "*");
        consumer.registerMessageListener((MessageListenerConcurrently)
                (messages, consumeConcurrentlyContext) -> {
                    for (MessageExt message : messages) {
                        //print info
                        System.out.println(message.toString());
                    }
                    return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
                });
        consumer.start();
    }
}
