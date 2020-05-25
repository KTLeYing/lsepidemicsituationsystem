package com.controller.deptadmin;

import com.dao.DeptAdminDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeptAlterTeaServlet")
public class DeptAlterTeaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        //获取表单请求的参数
        String tno = req.getParameter("tno");
        String tname = req.getParameter("tname");
        String tsex = req.getParameter("tsex");
        String tage = req.getParameter("tage");
        String tdept = req.getParameter("tdept");
        String tphone = req.getParameter("tphone");
        String tpsw = req.getParameter("tpsw");

        //数据类型转换
        int tage1 = Integer.parseInt(tage);

        String sql = "update teacher set tname = ?, tsex = ?, tage = ?, tdept = ?, tphone = ?, tpsw = ? where tno = ?";
        Object[] objects = {tname, tsex, tage1, tdept, tphone, tpsw, tno};

        int num = DeptAdminDao.executeUpdate(sql, objects);

        System.out.println(num);

//        req.getRequestDispatcher("/DeptQueryTeaByPageServlet?currentPage=1&rows=8").forward(req, resp);
        req.getRequestDispatcher("/DeptQueryTeaByPageServlet?currentPage=1&rows=7&tno=&tname=&tsex=").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
