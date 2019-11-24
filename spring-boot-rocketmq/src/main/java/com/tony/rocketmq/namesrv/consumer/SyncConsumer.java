package com.tony.rocketmq.namesrv.consumer;

import com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeOrderlyStatus;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerOrderly;
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
//        consumer.registerMessageListener((MessageListenerConcurrently)
//                (messages, consumeConcurrentlyContext) -> {
//                    for (MessageExt message : messages) {
//                        //print info
//                        System.out.println(message.toString());
//                    }
//                    return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
//                });
        consumer.registerMessageListener(
                (MessageListenerOrderly) (messages, consumeOrderlyContext) -> {
                    for (MessageExt message : messages) {
                        System.out.println(message.toString());
                    }
                    return ConsumeOrderlyStatus.SUCCESS;
                });
        //console 肯定使用这个api
//        consumer.queryMessage()
        consumer.start();
    }
}
