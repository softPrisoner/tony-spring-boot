package com.tony.java8.time;

import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * @author tony
 * @description ZonedDateTimeTest
 * @copyright rainbow
 * @date 2020/04/15
 */
public class ZonedDateTimeTest {
    public static void main(String[] args) {
        //Default Zone Asia/Shanghai
        ZonedDateTime zdt = ZonedDateTime.now();
        System.out.println(zdt);
        //America/New_York
        ZonedDateTime zdt1 = ZonedDateTime.now(ZoneId.of("America/New_York"));
        System.out.println(zdt1);
    }


}
