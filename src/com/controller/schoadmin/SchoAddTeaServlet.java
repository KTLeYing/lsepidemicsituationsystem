package com.controller.schoadmin;

import com.dao.DeptAdminDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/SchoAddTeaServlet")
public class SchoAddTeaServlet extends HttpServlet {

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

        String sql = null;

        System.out.println("shgshgh");

        //查询是否存在此人
        sql = "select count(*) as num from teacher where tno = ?";
        Object[] objects = {tno};
        int count = DeptAdminDao.findTotalCount(sql, objects);

        if (count == 0){//无则操作
            sql = "insert into teacher values(?, ?, ?, ?, ?, ?, ?)";
            Object[] objects1 = {tno, tname, tsex, tage1, tdept, tphone, tpsw};

            int num = DeptAdminDao.executeUpdate(sql, objects1);

            System.out.println(num);

            req.getRequestDispatcher("/SchoQueryTeaByPageServlet?currentPage=1&rows=7&tno=&tname=&tdept=").forward(req, resp);
        }else {
            req.getRequestDispatcher("/view/alluse/existdataofadd.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
