package com.tony.date.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author tony
 * @describe Controller
 * @date 2019/08/08
 */
@RestController
public class TimeController {

    @PostMapping("/date")
    public String date(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date) {
        System.out.println(date);
        return "success";
    }

    @PostMapping("/dateformat")
    public String localDate(@RequestParam("localDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate localDate) {
        return "success";
    }

    /**
     * 转换异常
     *
     * @param localDateTime
     * @retur
     */
    @PostMapping("/localdatetime")
    public String localDateTime(@RequestParam("localDateTime") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                        LocalDateTime localDateTime) {
        return "success";
    }

    /**
     * 转换不成功
     * @param localDateTime
     * @return
     */
    @PostMapping("/localdatetime1")
    public String localDateTime1(@RequestParam("localDateTime") @DateTimeFormat(pattern = "yyyy-MM-dd")
                                         LocalDateTime localDateTime) {
        return "success";
    }
}
