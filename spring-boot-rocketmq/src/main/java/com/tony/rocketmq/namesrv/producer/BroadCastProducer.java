package com.tony.rocketmq.namesrv.producer;

import com.alibaba.fastjson.JSON;
import com.alibaba.rocketmq.client.exception.MQBrokerException;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;
import com.alibaba.rocketmq.remoting.common.RemotingHelper;
import com.alibaba.rocketmq.remoting.exception.RemotingException;
import com.tony.rocketmq.namesrv.domain.OrderCreateDTO;

import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * @author tony
 * @describe BroadCastConsumer001
 * @date 2019-09-04
 */
public class BroadCastProducer {

    public static void main(String[] args) throws UnsupportedEncodingException, InterruptedException, RemotingException, MQClientException, MQBrokerException {
        DefaultMQProducer producer = new DefaultMQProducer("test");
        producer.setNamesrvAddr("localhost:9876");
        producer.setSendMsgTimeout(30000);
        producer.setHeartbeatBrokerInterval(2000);
        producer.start();
        OrderCreateDTO orderCreateDTO = new OrderCreateDTO().setCreateTime(Timestamp
                .valueOf(LocalDateTime.now()))
                .setOrderId("order10000000001")
                .setBuyerId("rb1000000001")
                .setOrderDesc("This is our first order.")
                .setState(1)
                .setTotalPrice(56.5);
        String orderDTO = JSON.toJSONString(orderCreateDTO);
        Message message = new Message("BroadCastTopic"
                , "tagA"
                , orderCreateDTO.getOrderId()
                , orderDTO.getBytes(RemotingHelper.DEFAULT_CHARSET));
        SendResult sendResult = producer.send(message);
        System.out.printf("%s %n", sendResult);
        producer.shutdown();
    }
}
