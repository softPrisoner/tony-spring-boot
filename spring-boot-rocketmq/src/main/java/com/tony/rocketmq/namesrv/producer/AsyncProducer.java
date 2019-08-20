package com.tony.rocketmq.namesrv.producer;

import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendCallback;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.client.producer.SendStatus;
import com.alibaba.rocketmq.common.message.Message;
import com.alibaba.rocketmq.remoting.exception.RemotingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;

/**
 * @author tony
 * @describe AsyncProducer
 * @date 2019-08-20
 */
public class AsyncProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(AsyncProducer.class);

    public static void main(String[] args) throws RemotingException, MQClientException, InterruptedException {
        DefaultMQProducer producer = new DefaultMQProducer("Group-Async-Test");
        producer.setNamesrvAddr("localhost:9876");
        //try again after send failed
        producer.setRetryTimesWhenSendAsyncFailed(2);
        Message message = new Message(
                "TP-Async-Test",
                "TagA",
                "orderId00001",
                "async topic test".getBytes(StandardCharsets.UTF_8)
        );
        //call the message queue
        producer.start();
        producer.setSendMsgTimeout(30000);
        //async message register call back listener
        producer.send(message, new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                SendStatus status = sendResult.getSendStatus();
                if (status == SendStatus.SEND_OK) {
                    LOGGER.info("send message [{}] success,receive result:[{}]", message, sendResult);
                } else if (status == SendStatus.FLUSH_SLAVE_TIMEOUT) {
                    LOGGER.error("send message [{}] failed,receive result:[{}] FLUSH_SLAVE_TIMEOUT", message, sendResult);
                } else if (status == SendStatus.FLUSH_DISK_TIMEOUT) {
                    LOGGER.error("send message [{}] failed,receive result:[{}] FLUSH_DISK_TIMEOUT", message, sendResult);

                } else if (status == SendStatus.SLAVE_NOT_AVAILABLE) {
                    LOGGER.error("send message [{}] failed,receive result:[{}] SLAVE_NOT_AVAILABLE", message, sendResult);

                }
            }

            @Override
            public void onException(Throwable throwable) {
                LOGGER.error("send message[{}] failed caused by:{}", message, throwable.getCause());
            }
        });
        //no message needs to send,prefer to register as a spring bean for instant
//        producer.shutdown();
    }
}
