package com.tony.rocketmq.namesrv.producer;

import com.alibaba.rocketmq.client.exception.MQBrokerException;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendCallback;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;
import com.alibaba.rocketmq.remoting.common.RemotingHelper;
import com.alibaba.rocketmq.remoting.exception.RemotingException;
import com.alibaba.rocketmq.shade.com.alibaba.fastjson.JSON;
import com.tony.rocketmq.namesrv.common.OrderGroupConstant;
import com.tony.rocketmq.namesrv.domain.OrderCancelDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import java.io.UnsupportedEncodingException;

/**
 * @author tony
 * @describe CancelOrderProducer
 * @date 2019-08-19
 */
public class OrderCancelProducer {
    private DefaultMQProducer producer;
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderCancelProducer.class);

    @PostConstruct
    public void init() throws MQClientException {
        producer = new DefaultMQProducer(OrderGroupConstant.ORDER_GROUP);
        producer.setNamesrvAddr(OrderGroupConstant.NAME_ADDR);
        producer.start();
    }

    public void cancelOrderToMQ(OrderCancelDTO orderCancelDTO) throws UnsupportedEncodingException, RemotingException, InterruptedException, MQBrokerException, MQClientException {
        String orderJson = JSON.toJSONString(orderCancelDTO);
        Message message = new Message("orderCancelDTO"
                , "TagA", orderJson.getBytes(RemotingHelper.DEFAULT_CHARSET));
        producer.setRetryTimesWhenSendAsyncFailed(2);
        producer.send(message, new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                System.out.println(sendResult.getMsgId() + " "
                        + sendResult.getQueueOffset() + " "
                        + sendResult.getTransactionId() + " "
                        + sendResult.getSendStatus());
            }

            @Override
            public void onException(Throwable throwable) {
                LOGGER.error("put order into mq failed caused by:", throwable.getCause());
            }
        });
    }
}
