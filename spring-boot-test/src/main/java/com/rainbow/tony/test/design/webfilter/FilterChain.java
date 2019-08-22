package com.rainbow.tony.test.design.webfilter;

import java.util.ArrayList;
import java.util.List;

public class FilterChain implements Filter {
    private int index = 0;
    public boolean ispass = true;
    private List<Filter> filters = new ArrayList<Filter>();

    public FilterChain addFilter(Filter filter) {
        filters.add(filter);
        return this;
    }

    @Override
    public void doFilter(Request request, Response response, FilterChain chain) {
        if (index == filters.size())
            return;
        if (!ispass)
            return;
        Filter f = filters.get(index);
        index++;
        f.doFilter(request, response, chain);
    }

//�����߼�

}
