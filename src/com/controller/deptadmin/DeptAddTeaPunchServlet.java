package com.controller.deptadmin;

import com.dao.DeptAdminDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeptAddTeaPunchServlet")
public class DeptAddTeaPunchServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        //获取表单请求的参数
        String tno = req.getParameter("tno");
        String tispunch = req.getParameter("tispunch");
        String tpunchdate = req.getParameter("tpunchdate");
        String tpunchtime = req.getParameter("tpunchtime");
        String tishot = req.getParameter("tishot");
        String tiscough = req.getParameter("tiscough");
        String tisseem = req.getParameter("tisseem");
        String tisdiagnose = req.getParameter("tisdiagnose");
        String tstatus = req.getParameter("tstatus");

        String sql = null;

        System.out.println("shgshgh");

        //查询是否已打卡
        sql = "select count(*) as num from teapunchin where tno = ? and tpunchdate = ?";
        Object[] objects = {tno, tpunchdate};
        int count = DeptAdminDao.findTotalCount(sql, objects);

        if (count == 0){//无则操作
            sql = "insert into teapunchin values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
            Object[] objects1 = {tno, tispunch, tpunchdate, tpunchtime, tishot, tiscough, tisseem, tisdiagnose, tstatus};

            int num = DeptAdminDao.executeUpdate(sql, objects1);

            System.out.println(num);

            req.getRequestDispatcher("/DeptQueryTeaPunchByPageServlet?currentPage=1&rows=7&tno=&tname=&tpunchdate=").forward(req, resp);
        }else {
            req.getRequestDispatcher("/view/alluse/existdataofadd.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
