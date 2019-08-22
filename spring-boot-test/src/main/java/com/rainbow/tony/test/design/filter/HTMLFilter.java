package com.rainbow.tony.test.design.filter;

public class HTMLFilter implements Filter {

	@Override
	public String doFilter(String str) {
		String r = str;
		r = r.replace("", "");
		return r;
	}

}
