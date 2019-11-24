package com.tony.rocketmq.namesrv.producer;

import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.common.message.Message;
    
 public class ScheduledMessageProducer {
    
     public static void main(String[] args) throws Exception {
         // Instantiate a producer to send scheduled messages
         DefaultMQProducer producer = new DefaultMQProducer("ExampleProducerGroup");
         // Launch producer
         producer.setNamesrvAddr("localhost:9876");
         producer.start();
         int totalMessagesToSend = 100;
//         for (int i = 0; i < totalMessagesToSend; i++) {
             Message message = new Message("TestTopic", ("Hello scheduled message " + 0).getBytes());
             // This message will be delivered to consumer 10 seconds later.
             message.setDelayTimeLevel(3);
             // Send the message
             producer.send(message);
//         }
    
         // Shutdown producer after use.
         producer.shutdown();
     }
        
 }