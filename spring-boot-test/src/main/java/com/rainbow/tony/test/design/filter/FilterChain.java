package com.rainbow.tony.test.design.filter;

import java.util.ArrayList;
import java.util.List;

public class FilterChain implements Filter {
    private List<Filter> filters = new ArrayList<Filter>(12);

    public FilterChain addFilter(Filter filter) {
        filters.add(filter);
        return this;
    }

    @Override
    public String doFilter(String str) {
        String r = str;
        for (Filter f : filters) {
            r = f.doFilter(str);
        }
        return r;
    }

}
