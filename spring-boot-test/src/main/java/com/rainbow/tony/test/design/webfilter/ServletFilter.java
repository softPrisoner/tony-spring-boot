package com.rainbow.tony.test.design.webfilter;

public class ServletFilter implements Filter {

	@Override
	public void doFilter(Request request, Response response, FilterChain chain) {
		if (1 != 2)
			chain.ispass = false;
		request.requestStr = request.requestStr.replace("3", "4") + "----ServletFilter";
		chain.doFilter(request, response, chain);
		response.responseStr = response.responseStr.replace("4", "3") + "----ServletFilter";

	}

}
