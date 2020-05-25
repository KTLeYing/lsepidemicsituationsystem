package com.controller.schoadmin;

import com.dao.DeptAdminDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/SchoDeleteStuServlet")
public class SchoDeleteStuServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        String sno = req.getParameter("sno");

        System.out.println(sno);

        String sql = null;
        Object[] objects = {sno};

        //查询是否存在此人
        sql = "select count(*) as num from student where sno = ?";
        int count = DeptAdminDao.findTotalCount(sql, objects);

        if (count > 0) { //有则继续操作
            //删除stupunchin中的该导游信息
            sql = "delete from stupunchin where sno = ?";
            int num1 = DeptAdminDao.executeUpdate(sql, objects);
            System.out.println(num1);

            //删除student表中该导游信息
            sql = "delete from student where sno = ?";
            int num2 = DeptAdminDao.executeUpdate(sql, objects);
            System.out.println(num2);

            req.getRequestDispatcher("/SchoQueryStuByPageServlet?currentPage=1&rows=7&sname=&sclass=&sdept=").forward(req, resp);
        }else {
            req.getRequestDispatcher("/view/alluse/noexistdataofdelete.jsp").forward(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
