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

@WebServlet("/StuLoginServlet")
public class StuLoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        String sno = req.getParameter("sno");
        String spsw = req.getParameter("spsw");
        System.out.println(sno);
        System.out.println(spsw);

        HttpSession session = req.getSession();
        session.setAttribute("sno", sno);

        String sql = "select * from student where sno = ? and spsw = ?";
        Object[] objects = {sno, spsw};
        ResultSet resultSet = FrontWebDao.login(sql, objects);
        try {
            if (resultSet.next()){
                req.setAttribute("httpUrl","/StuInfoServlet");
                req.setAttribute("info", "登录成功!即将跳转至学生信息页面!");
                req.setAttribute("title","登录成功");
                req.getRequestDispatcher("/view/frontweb/info.jsp").forward(req, resp);
            }else {
                req.setAttribute("httpUrl","/view/frontweb/stulogin.jsp");
                req.setAttribute("info", "登录失败!学号或密码错误!即将跳转至登录页面!");
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
