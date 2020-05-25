package com.controller.frontweb;

import com.dao.FrontWebDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/PubNewsServlet")
public class PubNewsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        String nid = req.getParameter("nid");
        int nid1 = Integer.parseInt(nid);
        String title = req.getParameter("title");
        String url = req.getParameter("url");

        System.out.println(nid1);
        System.out.println(title);
        System.out.println(url);

        //获取当前时间，并格式化
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date1 = simpleDateFormat.format(date);
        System.out.println(date1);

        String sql = null;

        sql = "select count(*) as num from news where nid = ?";
        Object[] objects = {nid1};
        int num = FrontWebDao.findTotalCount(sql, objects);
        System.out.println(num);
        if (num == 0){//无则发布
            sql = "insert into news values(?, ? , ?, ?)";
            Object[] objects1 = {nid1, title, url, date1};
            int num1 = FrontWebDao.executeUpdate(sql, objects1);
            if (num1 > 0){
                resp.getWriter().write("<script>alert('发布成功！'); window.location='" + req.getContextPath() + "/view/frontweb/pubnews.jsp';" +  "window.close();</script>");
            }else {
                resp.getWriter().write("<script>alert('发布失败！'); window.location='" + req.getContextPath() + "/view/frontweb/pubnews.jsp';" +  "window.close();</script>");
            }
        }else {//否则不能发布
            resp.getWriter().write("<script>alert('发布失败！此新闻编号已存在！'); window.location='" + req.getContextPath() + "/view/frontweb/pubnews.jsp';" +  "window.close();</script>");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
