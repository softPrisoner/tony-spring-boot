package com.tony.java8.lamda.transaction;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * @author tony
 * @description Trader
 * @copyright rainbow
 * @date 2020/03/25
 */
@Data
@Builder
@AllArgsConstructor
@ToString
public class Trader {
    private final String name;
    private final String city;

}
