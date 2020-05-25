package com.controller.deptadmin;

import com.dao.DeptAdminDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeptDeleteTeaPunchServlet")
public class DeptDeleteTeaPunchServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        //获取请求参数
        String tnodate = req.getParameter("tnodate");

        System.out.println(tnodate);

        //分离两个参数,用日期和学号来删除
        String[] params = tnodate.split(",");
        String tno = params[0];
        String tpunchdate = params[1];

        System.out.println(tno);
        System.out.println(tpunchdate);

        //字符串转为日期类型
//        Date spunchdate1 = new Date(spunchdate);
        //或
//        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
//        Date spunchdate1 = ft.format(spunchdate);

        String sql = null;
        Object[] objects = {tno, tpunchdate};

        //查询是否存在此人
        sql = "select count(*) as num from teapunchin where tno = ? and tpunchdate = ?";
        int count = DeptAdminDao.findTotalCount(sql, objects);

        if (count > 0) { //有则继续操作
            //删除stupunchin中的该信息
            sql = "delete from teapunchin where tno = ? and tpunchdate = ?";
            int num1 = DeptAdminDao.executeUpdate(sql, objects);
            System.out.println(num1);

            req.getRequestDispatcher("/DeptQueryTeaPunchByPageServlet?currentPage=1&rows=7&tno=&tname=&tpunchdate=").forward(req, resp);
        }else {
            req.getRequestDispatcher("/view/alluse/noexistdataofdelete.jsp").forward(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
