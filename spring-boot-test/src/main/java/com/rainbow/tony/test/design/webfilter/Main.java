package com.rainbow.tony.test.design.webfilter;

public class Main {
    public static void main(String[] args) {
        String msg = "1234";
        Request request = new Request();
        request.setRequestStr(msg);
        Response response = new Response();
        response.setResponseStr("1234");
        FilterChain fc = new FilterChain()
                .addFilter(new SensitiveFilter())
                .addFilter(new HTMLFilter())
                .addFilter(new ServletFilter());
        fc.doFilter(request, response, fc);
        System.out.println(request.requestStr);
        System.out.println(response.responseStr);
    }

}
