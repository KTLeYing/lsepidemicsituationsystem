package com.controller.frontweb;

import com.dao.FrontWebDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/TeaLoginServlet")
public class TeaLoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        String tno = req.getParameter("tno");
        String tpsw = req.getParameter("tpsw");
        System.out.println(tno);
        System.out.println(tpsw);

        HttpSession session = req.getSession();
        session.setAttribute("tno", tno);

        String sql = "select * from teacher where tno = ? and tpsw = ?";
        Object[] objects = {tno, tpsw};
        ResultSet resultSet = FrontWebDao.login(sql, objects);
        try {
            if (resultSet.next()){
                req.setAttribute("httpUrl","/TeaInfoServlet");
                req.setAttribute("info", "登录成功!即将跳转至教师信息页面!");
                req.setAttribute("title","登录成功");
                req.getRequestDispatcher("/view/frontweb/info.jsp").forward(req, resp);
            }else {
                req.setAttribute("httpUrl","/view/frontweb/tealogin.jsp");
                req.setAttribute("info", "登录失败!教工号或密码错误!即将跳转至登录页面!");
                req.setAttribute("title","登录失败");
                req.getRequestDispatcher("/view/frontweb/info.jsp").forward(req, resp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
