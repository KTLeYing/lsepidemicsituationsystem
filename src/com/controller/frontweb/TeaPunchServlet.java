package com.controller.frontweb;

import com.dao.DeptAdminDao;
import com.dao.FrontWebDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/TeaPunchServlet")
public class TeaPunchServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        //获取sno
        HttpSession session = req.getSession();
        String tno = (String) session.getAttribute("tno");
        System.out.println(tno);

        //获取表单请求的参数
        /*String tno = req.getParameter("tno");*/
        String tishot = req.getParameter("tishot");
        String tiscough = req.getParameter("tiscough");
        String tisseem = req.getParameter("tisseem");
        String tisdiagnose = req.getParameter("tisdiagnose");
        String tstatus = req.getParameter("tstatus");

        String tispunch = "是";
        Date date = new Date();
        //获取当前日期
        SimpleDateFormat sf1 = new SimpleDateFormat("yyyy-MM-dd");
        String tpunchdate = sf1.format(date);
        System.out.println(tpunchdate);
        //获取当前时间
        SimpleDateFormat sf2 = new SimpleDateFormat("HH:mm");
        String tpunchtime = sf2.format(date);
        System.out.println(tpunchtime);

        String sql = null;

        //查询是否已经打卡
        sql = "select count(*) as num from teapunchin where tno = ? and tpunchdate = ?";
        Object[] objects1 = {tno, tpunchdate};
        int count = FrontWebDao.findTotalCount(sql, objects1);

        if (count == 0){//无则操作
            sql = "insert into teapunchin values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
            Object[] objects2 = {tno, tispunch, tpunchdate, tpunchtime, tishot, tiscough, tisseem, tisdiagnose, tstatus};

            int num = FrontWebDao.executeUpdate(sql, objects2);

            System.out.println(num);

            resp.getWriter().write("<script>alert('打卡成功！'); window.location='" + req.getContextPath() + "/TeaInfoServlet';" +  "window.close();</script>");

        }else {//已经打卡
            resp.getWriter().write("<script>alert('您今天已成功打卡！不能再次打卡！'); window.location='" + req.getContextPath() + "/TeaInfoServlet';" +  "window.close();</script>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
