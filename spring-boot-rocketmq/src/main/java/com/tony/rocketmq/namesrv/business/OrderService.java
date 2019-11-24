package com.tony.rocketmq.namesrv.business;


import com.tony.rocketmq.namesrv.domain.OrderCreateDTO;

/**
 * @author tony
 * @describe OrderService
 * @date 2019-08-19
 */
public interface OrderService {
    /**创建订单*/
    void orderCreateInvoke(OrderCreateDTO orderDO);
    /**取消订单*/
    void orderCancelInvoke();
    /**订单支付*/
    void orderConfirmInvoke();
    /**订单退单*/
    void orderRefundInvoke();
}
