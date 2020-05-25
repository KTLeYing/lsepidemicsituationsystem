package com.controller.frontweb;

import com.dao.FrontWebDao;
import com.entity.News;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;

@WebServlet("/MoreNewsServlet")
public class MoreNewsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        String sql = "select * from news";
        Object[] objects = {};

        ArrayList<News> newsArrayList = new ArrayList<News>();

        ResultSet resultSet = FrontWebDao.qureyInfo(sql, objects);

        try {
            while (resultSet.next()){
                News news = new News();
                news.setTitle(resultSet.getString("title"));
                news.setUrl(resultSet.getString("url"));
                news.setPubdate(resultSet.getDate("pubdate"));
                newsArrayList.add(news);
                System.out.println(news);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(newsArrayList);

        req.setAttribute("newsArrayList", newsArrayList);

        req.getRequestDispatcher("/view/frontweb/morenews.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
