package com.controller.frontweb;

import com.dao.DeptAdminDao;
import com.dao.FrontWebDao;
import com.mysql.fabric.Response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/StuPunchServlet")
public class StuPunchServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        //获取sno
        HttpSession session = req.getSession();
        String sno = (String) session.getAttribute("sno");
        System.out.println(sno);

        //获取表单请求的参数
        /*String sno = req.getParameter("sno");*/
        String sishot = req.getParameter("sishot");
        String siscough = req.getParameter("siscough");
        String sisseem = req.getParameter("sisseem");
        String sisdiagnose = req.getParameter("sisdiagnose");
        String sstatus = req.getParameter("sstatus");

        String sispunch = "是";
        Date date = new Date();
        //获取当前日期
        SimpleDateFormat sf1 = new SimpleDateFormat("yyyy-MM-dd");
        String spunchdate = sf1.format(date);
        System.out.println(spunchdate);
        //获取当前时间
        SimpleDateFormat sf2 = new SimpleDateFormat("HH:mm");
        String spunchtime = sf2.format(date);
        System.out.println(spunchtime);

        String sql = null;

        //查询是否已经打卡
        sql = "select count(*) as num from stupunchin where sno = ? and spunchdate = ?";
        Object[] objects1 = {sno, spunchdate};
        int count = FrontWebDao.findTotalCount(sql, objects1);

        if (count == 0){//无则操作
            sql = "insert into stupunchin values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
            Object[] objects2 = {sno, sispunch, spunchdate, spunchtime, sishot, siscough, sisseem, sisdiagnose, sstatus};

            int num = FrontWebDao.executeUpdate(sql, objects2);

            System.out.println(num);

            resp.getWriter().write("<script>alert('打卡成功！'); window.location='" + req.getContextPath() + "/StuInfoServlet';" +  "window.close();</script>");

        }else {//已打卡
            resp.getWriter().write("<script>alert('您今天已成功打卡！不能再次打卡！'); window.location='" + req.getContextPath() + "/StuInfoServlet';" +  "window.close();</script>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
