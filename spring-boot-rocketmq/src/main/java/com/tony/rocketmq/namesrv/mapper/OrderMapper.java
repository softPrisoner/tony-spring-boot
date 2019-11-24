package com.tony.rocketmq.namesrv.mapper;

import com.tony.rocketmq.namesrv.domain.OrderCancelDTO;
import com.tony.rocketmq.namesrv.domain.OrderConfirmDTO;
import com.tony.rocketmq.namesrv.domain.OrderCreateDTO;
import com.tony.rocketmq.namesrv.domain.OrderRefundDTO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author tony
 * @describe OrderMapper
 * @date 2019-08-19
 */
@Mapper
public interface OrderMapper {

    void orderCreateDBInsert(OrderCreateDTO orderCreateDTO);

    void orderCancelDBUpdate(OrderCancelDTO orderCancelDTO);

    void orderConfirmDBUpdate(OrderConfirmDTO orderConfirmDTO);

    void orderRefundDBUpdate(OrderRefundDTO orderRefundDTO);
}
