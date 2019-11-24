package com.tony.rocketmq.namesrv.consumer;

import com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.common.message.MessageExt;
import net.jcip.annotations.GuardedBy;


/**
 * @author tony
 * @describe OneWayConsumer
 * @date 2019-08-20
 */
public class OneWayConsumer {
    @GuardedBy("this")
    public static void main(String[] args) throws MQClientException {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("GP-OneWay");
        consumer.setNamesrvAddr("localhost:9876");
        consumer.subscribe("TP-OneWay-Test", "TAG-Log");
        consumer.registerMessageListener((MessageListenerConcurrently) (messageExts, consumeConcurrentlyContext) -> {
                    MessageExt messageExt = messageExts.get(messageExts.size());
                    System.out.println(messageExt);
                    return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
                }
        );
        consumer.start();
    }
}
