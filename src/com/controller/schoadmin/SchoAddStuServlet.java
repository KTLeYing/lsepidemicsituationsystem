package com.controller.schoadmin;

import com.dao.DeptAdminDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/SchoAddStuServlet")
public class SchoAddStuServlet extends HttpServlet {

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
        String specialty = req.getParameter("specialty");
        String sclass = req.getParameter("sclass");
        String sdept = req.getParameter("sdept");
        String sphone = req.getParameter("sphone");
        String spsw = req.getParameter("spsw");

        //数据类型转换
        int sage1 = Integer.parseInt(sage);

        String sql = null;

        System.out.println("shgshgh");

        //查询是否存在此人
        sql = "select count(*) as num from student where sno = ?";
        Object[] objects = {sno};
        int count = DeptAdminDao.findTotalCount(sql, objects);

        if (count == 0){//无则操作
            sql = "insert into student values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
            Object[] objects1 = {sno, sname, ssex, sage1, sclass, specialty, sdept, sphone, spsw};

            int num = DeptAdminDao.executeUpdate(sql, objects1);

            System.out.println(num);

            req.getRequestDispatcher("/SchoQueryStuByPageServlet?currentPage=1&rows=7&sname=&sclass=&sdept=").forward(req, resp);
        }else {
            req.getRequestDispatcher("/view/alluse/existdataofadd.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
