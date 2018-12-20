package com.lewis.spring1.common;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CrosFilter implements javax.servlet.Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletResponse rep = (HttpServletResponse) servletResponse;
        //允许8081访问:"http://localhost:8081"换为*表示允许所有
        rep.addHeader("Access-Control-Allow-Origin", "http://localhost:*");
        //允许访问方法GET：GET"换为*表示允许所有
        rep.addHeader("Access-Control-Allow-Methods", "*");
        filterChain.doFilter(servletRequest, rep);
    }

    @Override
    public void destroy() {

    }
}