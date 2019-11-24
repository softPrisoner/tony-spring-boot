package com.tony.rocketmq.namesrv.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.Map;

/**
 * @author tony
 * @describe OrderController
 * @date 2019-08-19
 */
@Controller
public class OrderController {
    @GetMapping("/order/create")
    public void orderCreateCommend(
            @RequestParam("accountId") String accountId,
            @RequestParam("items") Map<Long, Long> items,
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date confirmTime) {

    }

    @GetMapping("/order/cancel")
    public void orderCancelCommand(
            @RequestParam("accountId") String accountId,
            @RequestParam("orderId") String orderId,
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date cancelTime) {
    }

    @GetMapping("/order/confirm")
    public void orderConfirmCommand(
            @RequestParam("accountId") String accountId,
            @RequestParam("orderId") String orderId,
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date confirmTime) {
    }

    @GetMapping("/order/refund")
    public void orderRefundCommand(
            @RequestParam("accountId") String accountId,
            @RequestParam("accountId") String orderId,
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date refundTime) {
    }
}
