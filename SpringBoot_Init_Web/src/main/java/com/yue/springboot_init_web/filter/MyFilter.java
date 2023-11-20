package com.yue.springboot_init_web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author yue
 * @description
 * @create 2023-03-06 17:37
 */
//@WebFilter(urlPatterns = "/my")
public class MyFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("=================================");
        System.out.println("自定义filter");
        chain.doFilter(request,response);
    }
}
