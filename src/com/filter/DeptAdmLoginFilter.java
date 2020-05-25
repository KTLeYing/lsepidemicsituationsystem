package com.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/view/deptadmin/deptmainview.jsp")
public class DeptAdmLoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        //3.从获取session中获取user
        Object deptadno = request.getSession().getAttribute("deptadno");
        System.out.println(deptadno);
        if (deptadno != null){
            //登录了，放行
            filterChain.doFilter(servletRequest, servletResponse);
        }else {
            //没有登录,跳转到登录页面
            request.getRequestDispatcher("/view/frontweb/deptadmlogin.jsp").forward(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
