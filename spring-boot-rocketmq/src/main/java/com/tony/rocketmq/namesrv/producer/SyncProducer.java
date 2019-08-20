package com.tony.rocketmq.namesrv.producer;

import com.alibaba.rocketmq.client.exception.MQBrokerException;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;
import com.alibaba.rocketmq.remoting.RPCHook;
import com.alibaba.rocketmq.remoting.common.RemotingHelper;
import com.alibaba.rocketmq.remoting.exception.RemotingException;
import com.alibaba.rocketmq.remoting.protocol.RemotingCommand;
import com.google.common.base.Preconditions;

import java.io.UnsupportedEncodingException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author tony
 * @describe SyncProducer
 * @date 2019-08-19
 */
public class SyncProducer {
    private static final Lock lock = new ReentrantLock(false);

    public static void main(String[] args) throws MQClientException, UnsupportedEncodingException, RemotingException, InterruptedException, MQBrokerException {
        // real time wait for success
        DefaultMQProducer producer = null;
        if (lock.tryLock(2, TimeUnit.SECONDS)) {
            producer = new DefaultMQProducer("order-group", new RPCHook() {
                @Override
                public void doBeforeRequest(String s, RemotingCommand remotingCommand) {
                    System.out.println("Before send message from producer:" + s + "code:" + remotingCommand.getCode());
                }

                @Override
                public void doAfterResponse(String s, RemotingCommand remotingCommand, RemotingCommand remotingCommand1) {
                    System.out.println("After send message from producer:" + s + "code:" + remotingCommand.getCode());
                }
            });
        }
        lock.unlock();
        Preconditions.checkNotNull(producer, "illegal state:producer is null");
        producer.setNamesrvAddr("localhost:9876");
        producer.start();
        Message message = new Message("orderTopic"
                , "TagA", "Hello RocketMQ".getBytes(RemotingHelper.DEFAULT_CHARSET));
        SendResult result = producer.send(message);
        System.out.println(result.getMsgId() + " "
                + result.getQueueOffset() + " "
                + result.getTransactionId() + " "
                + result.getSendStatus());
    }

}
