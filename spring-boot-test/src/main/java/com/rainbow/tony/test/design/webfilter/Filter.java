package com.rainbow.tony.test.design.webfilter;

public interface Filter {
    void doFilter(Request request, Response response, FilterChain chain);
}
