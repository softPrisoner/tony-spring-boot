package com.tony.rocketmq.namesrv.consumer;

import com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.common.consumer.ConsumeFromWhere;
import com.alibaba.rocketmq.common.message.MessageExt;

/**
 * @author tony
 * @describe SyncConsumer
 * @date 2019-08-19
 */
public class AsyncConsumer {
    public static void main(String[] args) throws MQClientException {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("Group-Async-Test");
        consumer.setNamesrvAddr("localhost:9876");
        consumer.subscribe("TP-Async-Test", "TagA");
//        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
//        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_LAST_OFFSET);
//        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_TIMESTAMP);
        consumer.registerMessageListener((MessageListenerConcurrently)
                (messages, consumeConcurrentlyContext) -> {

                    for (MessageExt message : messages) {
                        //print info
                        try {
                            //make up with dealing with business
                            Thread.sleep(30000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(message.toString());
                    }

                    return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
                });
        consumer.start();
    }
}
