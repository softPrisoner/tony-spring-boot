package com.tony.statemachine.config;

/**
 * @author tony
 * @describe EventConfig
 * @date 2019-10-26
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.statemachine.annotation.OnTransition;
import org.springframework.statemachine.annotation.WithStateMachine;

@WithStateMachine
public class EventConfig {
    private static final Logger LOGGER = LoggerFactory.getLogger(EventConfig.class);

    @OnTransition(target = "UNPAID")
    public void create() {
        LOGGER.info("订单创建,待支付");
    }

    @OnTransition(source = "UNPAID", target = "WAITING FOR RECEIVE")
    public void pay() {
        LOGGER.info("已付款,等待收货");
    }

    @OnTransition(source = "WAITING FOR RECEIVE", target = "DONE")
    public void receive() {
        LOGGER.info("用户已收货,订单完成");
    }
}
