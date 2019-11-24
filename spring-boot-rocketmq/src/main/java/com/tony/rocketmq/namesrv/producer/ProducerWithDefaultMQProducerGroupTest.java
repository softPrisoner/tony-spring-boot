package com.tony.rocketmq.namesrv.producer;

import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.common.MixAll;
import com.alibaba.rocketmq.common.message.Message;

/**
 * @author tony
 * @describe ProducerTest
 * @date 2019-09-05
 */
public class ProducerWithDefaultMQProducerGroupTest {
    public static void main(String[] args) throws MQClientException {
        //use default group for test exception
        DefaultMQProducer producer = new DefaultMQProducer(MixAll.DEFAULT_PRODUCER_GROUP);
        producer.setNamesrvAddr("localhost:9876");
        Message message = new Message();
        producer.start();
    }
}
