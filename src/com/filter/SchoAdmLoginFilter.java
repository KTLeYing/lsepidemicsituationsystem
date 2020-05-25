package com.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/view/schoadmin/schomainview.jsp")
public class SchoAdmLoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        //3.从获取session中获取user
        Object schoadno = request.getSession().getAttribute("schoadno");
        System.out.println(schoadno);
        if (schoadno != null){
            //登录了，放行
            filterChain.doFilter(servletRequest, servletResponse);
        }else {
            //没有登录,跳转到登录页面
            request.getRequestDispatcher("/view/frontweb/schoadmlogin.jsp").forward(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
