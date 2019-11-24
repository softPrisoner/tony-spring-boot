package com.tony.rocketmq.namesrv.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.sql.Timestamp;

/**
 * @author tony
 * @describe OrderCreateDTO
 * @date 2019-08-19
 */
@Data
@ToString
@NoArgsConstructor
@Accessors(chain = true)
public class OrderCreateDTO {
    private String orderId;
    private int state;
    private Number totalPrice;
    private Timestamp createTime;
    private Timestamp confirmTime;
    private Timestamp cancelTime;
    private String refundTime;
    private String orderDesc;
    private String buyerId;
}
