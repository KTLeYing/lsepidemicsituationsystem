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

@WebServlet("/DelNewsServlet")
public class DelNewsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        String nid = req.getParameter("nid");
        int nid1 = Integer.parseInt(nid);

        System.out.println(nid1);

        String sql = null;

        sql = "select count(*) as num from news where nid = ?";
        Object[] objects = {nid1};
        int num = FrontWebDao.findTotalCount(sql, objects);
        System.out.println(num);
        if (num > 0){//有则删除
            sql = "delete from news where nid = ?";
            Object[] objects1 = {nid1};
            int num1 = FrontWebDao.executeUpdate(sql, objects1);
            if (num1 > 0){
                resp.getWriter().write("<script>alert('删除成功！'); window.location='" + req.getContextPath() + "/view/frontweb/delnews.jsp';" +  "window.close();</script>");
            }else {
                resp.getWriter().write("<script>alert('删除失败！'); window.location='" + req.getContextPath() + "/view/frontweb/delnews.jsp';" +  "window.close();</script>");
            }
        }else {//否则不能删除
            resp.getWriter().write("<script>alert('删除失败！不存在此新闻编号！'); window.location='" + req.getContextPath() + "/view/frontweb/delnews.jsp';" +  "window.close();</script>");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
