package com.controller.deptadmin;

import com.dao.DeptAdminDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeptAlterStuServlet")
public class DeptAlterStuServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        //获取表单请求的参数
        String sno = req.getParameter("sno");
        String sname = req.getParameter("sname");
        String ssex = req.getParameter("ssex");
        String sage = req.getParameter("sage");
        String sclass = req.getParameter("sclass");
        String specialty = req.getParameter("specialty");
        String sdept = req.getParameter("sdept");
        String sphone = req.getParameter("sphone");
        String spsw = req.getParameter("spsw");

        //数据类型转换
        int sage1 = Integer.parseInt(sage);

        String sql = "update student set sname = ?, ssex = ?, sage = ?, sclass = ?, specialty = ?, sdept = ?, sphone = ?, spsw = ? where sno = ?";
        Object[] objects = {sname, ssex, sage1, sclass, specialty, sdept, sphone, spsw, sno};

        int num = DeptAdminDao.executeUpdate(sql, objects);

        System.out.println(num);

//        req.getRequestDispatcher("/DeptQueryStuByPageServlet?currentPage=1&rows=8").forward(req, resp);

        req.getRequestDispatcher("/DeptQueryStuByPageServlet?currentPage=1&rows=7&sname=&sclass=&specialty=").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
