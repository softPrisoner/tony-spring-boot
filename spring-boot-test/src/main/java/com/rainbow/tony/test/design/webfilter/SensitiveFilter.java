package com.rainbow.tony.test.design.webfilter;

public class SensitiveFilter implements Filter {

    @Override
    public void doFilter(Request request, Response response, FilterChain chain) {
        request.requestStr = request.requestStr.replace("1", "2") + "-------SensitiveFilter";
        chain.doFilter(request, response, chain);
        response.responseStr = response.responseStr.replace("2", "1") + "-------SensitiveFilter";
    }

}
