package com.controller.deptadmin;

import com.dao.DeptAdminDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/DeptDeleteTeaPunchServlet1")
public class DeptDeleteTeaPunchServlet1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        //获取请求参数
        String tno = req.getParameter("tno");
        String tpunchdate = req.getParameter("tpunchdate");

        System.out.println(tno);
        System.out.println(tpunchdate);

        //获取登录时的session会话对象
        HttpSession session = req.getSession();
//        String userName = (String) session.getAttribute("userName");
//        String sno = (String) session.getAttribute("sno");
        String belong = (String) session.getAttribute("belong");


        //字符串转为日期类型
//        Date spunchdate1 = new Date(spunchdate);
        //或
//        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
//        Date spunchdate1 = ft.format(spunchdate);

        String sql = null;
        Object[] objects = {tno, tpunchdate, belong};

        //查询是否存在此人
        sql = "select count(*) as num from teacher t,teapunchin tp where t.tno = tp.tno and tp.tno = ? and tp.tpunchdate = ? and t.tdept = ?";
        int count = DeptAdminDao.findTotalCount(sql, objects);

        Object[] objects1 = {tno, tpunchdate};
        if (count > 0) { //有则继续操作
            //删除stupunchin中的该信息
            sql = "delete from teapunchin where tno = ? and tpunchdate = ?";
            int num1 = DeptAdminDao.executeUpdate(sql, objects1);
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
