package com.controller.frontweb;

import com.dao.FrontWebDao;
import com.entity.Student;
import com.entity.Teacher;
import com.utils.JDBCUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.ResultSet;

@WebServlet("/TeaInfoServlet")
public class TeaInfoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        HttpSession session = req.getSession();
        String tno = (String) session.getAttribute("tno");


        String sql = "select * from teacher where tno = ?";
        Object[] objects = {tno};
        ResultSet resultSet = FrontWebDao.qureyInfo(sql, objects);
        Teacher teacher = new Teacher();
        try {
            while (resultSet.next()){
                teacher.setTno(resultSet.getString("tno"));
                teacher.setTname(resultSet.getString("tname"));
                teacher.setTsex(resultSet.getString("tsex"));
                teacher.setTage(resultSet.getInt("tage"));
                teacher.setTdept(resultSet.getString("tdept"));
                teacher.setTphone(resultSet.getString("tphone"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(resultSet);
        }

        req.setAttribute("teacher", teacher);

        req.getRequestDispatcher("/view/frontweb/teainfo.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
