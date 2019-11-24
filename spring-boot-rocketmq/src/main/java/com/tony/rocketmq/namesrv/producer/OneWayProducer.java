package com.tony.rocketmq.namesrv.producer;

import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.common.message.Message;
import com.alibaba.rocketmq.remoting.exception.RemotingException;

/**
 * @author tony
 * @describe OneWayProducer
 * @date 2019-08-20
 */
public class OneWayProducer {
    public static void main(String[] args) throws RemotingException, MQClientException, InterruptedException {
        DefaultMQProducer producer = new DefaultMQProducer("GP-OneWay");
        producer.setNamesrvAddr("localhost:9876");
        producer.start();
        Message messageExt = new Message("TP-OneWay-Test", "TAG-Log", "Log-Content".getBytes());
        //messageExt.setBodyCRC(123456);
        //expression for more tag message store
//      messageExt.setBornHost(new InetSocketAddress("localhost", 1234));
        producer.sendOneway(messageExt);
        System.out.println("消息发送成功");
    }
}
