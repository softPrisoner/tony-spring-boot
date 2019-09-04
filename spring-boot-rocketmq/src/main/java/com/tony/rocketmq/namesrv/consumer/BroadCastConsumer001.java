package com.tony.rocketmq.namesrv.consumer;

import com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.common.consumer.ConsumeFromWhere;
import com.alibaba.rocketmq.common.message.MessageExt;
import com.alibaba.rocketmq.common.protocol.heartbeat.MessageModel;

/**
 * @author tony
 * @describe BroadCastConsumer001
 * @date 2019-09-04
 */
public class BroadCastConsumer001 {

    public static void main(String[] args) throws MQClientException {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("test");
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
        consumer.setMessageModel(MessageModel.BROADCASTING);
        consumer.setNamesrvAddr("localhost:9876");
        //such as tag1 tag2 tag3
        consumer.subscribe("BroadCastTopic", "");
        consumer.registerMessageListener((MessageListenerConcurrently) (messageExtList, consumeConcurrentlyContext) ->
        {
            for (MessageExt messageExt : messageExtList) {
                byte[] body = messageExt.getBody();
                String message = new String(body);
                System.out.println(message);
            }
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        });
        consumer.start();
//        consumer.shutdown();
    }
}
