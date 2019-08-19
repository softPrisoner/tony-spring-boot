package com.tony.rocketmq.namesrv.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author tony
 * @describe OrderTopicType
 * @date 2019-08-19
 */

@AllArgsConstructor
public enum OrderTopicType {
    ORDER_CREATE_TOPIC("TP-Order-Create"),
    ORDER_CANCEL_TOPIC("TP-Order-Cancel"),
    ORDER_CONFIRM_TOPIC("TP-Order-Confirm"),
    ORDER_REFUND_TOPIC("TP-Order-Refund");
    @Getter
    public String type;
}
