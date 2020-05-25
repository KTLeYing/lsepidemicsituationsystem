package com.controller.frontweb;

import com.dao.FrontWebDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/TeaAlterPswServlet")
public class TeaAlterPswServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        HttpSession session = req.getSession();
        String tno = (String) session.getAttribute("tno");

        String tpsw = req.getParameter("tpsw");
        String tpsw1 = req.getParameter("tpsw1");

        //判断两次密码是否相同
        if (tpsw.equals(tpsw1)){//相同则进行修改操作
            String sql = "update teacher set tpsw = ? where tno = ?";
            Object[] objects = {tpsw, tno};
            int num = FrontWebDao.executeUpdate(sql, objects);
            if (num > 0){
                resp.getWriter().write("<script>alert('修改密码成功！请重新登录！'); window.location='" + req.getContextPath() + "/view/frontweb/tealogin.jsp';" +  "window.close();</script>");
            }else {
                resp.getWriter().write("<script>alert('修改密码失败！请重新输入密码！'); window.location='" + req.getContextPath() + "/view/frontweb/teaalterpsw.jsp';" +  "window.close();</script>");
            }
        }else {//不同则重新输入密码
            resp.getWriter().write("<script>alert('两次密码不一样!请重新输入密码！'); window.location='" + req.getContextPath() + "/view/frontweb/teaalterpsw.jsp';" +  "window.close();</script>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
