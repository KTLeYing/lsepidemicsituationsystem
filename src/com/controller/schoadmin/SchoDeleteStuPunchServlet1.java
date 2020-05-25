package com.controller.schoadmin;

import com.dao.DeptAdminDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/SchoDeleteStuPunchServlet1")
public class SchoDeleteStuPunchServlet1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        //获取请求参数
        String sno = req.getParameter("sno");
        String spunchdate = req.getParameter("spunchdate");

        System.out.println(sno);
        System.out.println(spunchdate);

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
        Object[] objects = {sno, spunchdate};

        //查询是否存在此人
        sql = "select count(*) as num from student s,stupunchin sp where s.sno = sp.sno and s.sno = ? and sp.spunchdate = ?";
        int count = DeptAdminDao.findTotalCount(sql, objects);

        if (count > 0) { //有则继续操作
            //删除stupunchin中的该信息
            sql = "delete from stupunchin where sno = ? and spunchdate = ?";
            int num1 = DeptAdminDao.executeUpdate(sql, objects);
            System.out.println(num1);

            req.getRequestDispatcher("/SchoQueryStuPunchByPageServlet?currentPage=1&rows=7&sname=&sclass=&sdept=&spunchdate=").forward(req, resp);
        }else {
            req.getRequestDispatcher("/view/alluse/noexistdataofdelete.jsp").forward(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
