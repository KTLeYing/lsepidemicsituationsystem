package com.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/view/frontweb/teainfo.jsp")
public class TeacherLoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        //3.从获取session中获取user
        Object tno = request.getSession().getAttribute("tno");
        System.out.println(tno);
        if (tno != null){
            //登录了，放行
            filterChain.doFilter(servletRequest, servletResponse);
        }else {
            //没有登录,跳转到登录页面
            request.getRequestDispatcher("/view/frontweb/tealogin.jsp").forward(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
