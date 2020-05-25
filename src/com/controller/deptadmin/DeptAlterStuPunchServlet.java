package com.controller.deptadmin;

import com.dao.DeptAdminDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeptAlterStuPunchServlet")
public class DeptAlterStuPunchServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        //获取表单请求的参数
        String sno = req.getParameter("sno");
        String sispunch = req.getParameter("sispunch");
        String spunchdate = req.getParameter("spunchdate");
        String spunchtime = req.getParameter("spunchtime");
        String sishot = req.getParameter("sishot");
        String siscough = req.getParameter("siscough");
        String sisseem = req.getParameter("sisseem");
        String sisdiagnose = req.getParameter("sisdiagnose");
        String sstatus = req.getParameter("sstatus");

        String sql = "update stupunchin set sispunch = ?,  spunchtime = ?, sishot = ?, siscough = ?, sisseem = ?, sisdiagnose = ?, sstatus = ? where sno = ? and spunchdate = ?";
        Object[] objects = {sispunch, spunchtime, sishot, siscough, sisseem, sisdiagnose, sstatus, sno, spunchdate};

        int num = DeptAdminDao.executeUpdate(sql, objects);

        System.out.println(num);

        req.getRequestDispatcher("/DeptQueryStuPunchByPageServlet?currentPage=1&rows=7&sname=&sclass=&spunchdate=").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
