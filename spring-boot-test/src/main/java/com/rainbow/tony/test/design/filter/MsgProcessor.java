package com.rainbow.tony.test.design.filter;

import lombok.Data;

@Data
public class MsgProcessor {
    private String msg;
    private FilterChain fc;

    public String processor() {
        String r = msg;
        return fc.doFilter(msg);
    }
}
