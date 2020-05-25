package com.controller.frontweb;

import com.dao.FrontWebDao;
import com.dao.StuDao;
import com.entity.Student;
import com.utils.JDBCUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;

@WebServlet("/StuInfoServlet")
public class StuInfoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        HttpSession session = req.getSession();
        String sno = (String) session.getAttribute("sno");


        String sql = "select * from student where sno = ?";
        Object[] objects = {sno};
        ResultSet resultSet = FrontWebDao.qureyInfo(sql, objects);
        Student student = new Student();
        try {
            while (resultSet.next()){
                student.setSno(resultSet.getString("sno"));
                student.setSname(resultSet.getString("sname"));
                student.setSsex(resultSet.getString("ssex"));
                student.setSage(resultSet.getInt("sage"));
                student.setSclass(resultSet.getString("sclass"));
                student.setSpecialty(resultSet.getString("specialty"));
                student.setSdept(resultSet.getString("sdept"));
                student.setSphone(resultSet.getString("sphone"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(resultSet);
        }

        req.setAttribute("student", student);

        req.getRequestDispatcher("/view/frontweb/stuinfo.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
