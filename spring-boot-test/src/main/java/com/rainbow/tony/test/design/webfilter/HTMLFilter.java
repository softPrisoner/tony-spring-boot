package com.rainbow.tony.test.design.webfilter;

public class HTMLFilter implements Filter {
    @Override
    public void doFilter(Request request, Response response, FilterChain chain) {
        if (1 != 2)
            chain.pass = false;
        request.requestStr = request.requestStr.replace("2", "3") + "-----HTMLFilter";
        chain.doFilter(request, response, chain);
        response.responseStr = response.responseStr.replace("3", "2") + "-----HTMLFilter";

    }

}
