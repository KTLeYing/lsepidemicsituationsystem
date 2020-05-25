package com.controller.deptadmin;

import com.dao.DeptAdminDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/DeptDeleteStuServlet1")
public class DeptDeleteStuServlet1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        String sno = req.getParameter("sno");

        System.out.println(sno);

        //获取登录时的session会话对象
        HttpSession session = req.getSession();
//        String userName = (String) session.getAttribute("userName");
//        String sno = (String) session.getAttribute("sno");
        String belong = (String) session.getAttribute("belong");

        System.out.println(belong);

        String sql = null;
        Object[] objects = {sno, belong};

        //查询是否存在此人
        sql = "select count(*) as num from student where sno = ? and sdept = ?";
        int count = DeptAdminDao.findTotalCount(sql, objects);

        Object[] objects1 = {sno};
        if (count > 0) { //有则继续操作
            //删除stupunchin中的该导游信息
            sql = "delete from stupunchin where sno = ?";
            int num1 = DeptAdminDao.executeUpdate(sql, objects1);
            System.out.println(num1);

            //删除student表中该导游信息
            sql = "delete from student where sno = ?";
            int num2 = DeptAdminDao.executeUpdate(sql, objects1);
            System.out.println(num2);

            req.getRequestDispatcher("/DeptQueryStuByPageServlet?currentPage=1&rows=7&sname=&sclass=&specialty=").forward(req, resp);
        }else {
            req.getRequestDispatcher("/view/alluse/noexistdataofdelete.jsp").forward(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
