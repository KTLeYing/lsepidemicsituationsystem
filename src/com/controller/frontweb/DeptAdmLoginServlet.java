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

@WebServlet("/DeptAdmLoginServlet")
public class DeptAdmLoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        //获取表单请求个参数
        String adno = req.getParameter("adno");
        String adpsw = req.getParameter("adpsw");
        String belong = req.getParameter("belong");
        System.out.println(belong);

        String sql = "select * from admin where adno = ? and adpsw = ? and belong = ?";
        Object[] objects = {adno, adpsw, belong};
        ResultSet resultSet = FrontWebDao.login(sql, objects);
        //判断密码和账号是否正确
        try {
            if (resultSet.next()){
                // 创建会话属性对象，后面处理请求要用
                HttpSession session = req.getSession();
                session.setAttribute("adno", adno);
                session.setAttribute("belong", belong);
                session.setAttribute("deptadno", adno);

                System.out.println("登陆成功!");
                req.setAttribute("httpUrl","/view/deptadmin/deptmainview.jsp");
                req.setAttribute("info", "登录成功!即将跳转至二级学院管理员后台首页!");
                req.setAttribute("title","登录成功");
                req.getRequestDispatcher("/view/frontweb/info.jsp").forward(req, resp);

            }else {
                System.out.println("用户名或密码错误!请重新登录!");
                //返回登录成功的信息
                req.setAttribute("httpUrl","/view/frontweb/deptadmlogin.jsp");
                req.setAttribute("info", "登录失败!管理员账号或密码错误!即将跳转至登录页面!");
                req.setAttribute("title","登录失败");
                req.getRequestDispatcher("/view/frontweb/info.jsp").forward(req, resp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
