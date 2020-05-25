package com.controller.tea;

import com.dao.StuDao;
import com.dao.TeaDao;
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
import java.util.ArrayList;

@WebServlet("/TeaQueryInfoServlet")
public class TeaQueryInfoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        HttpSession session = req.getSession();
        String userName = (String) session.getAttribute("userName");
        String tno = (String) session.getAttribute("tno");

        System.out.println(userName);
        System.out.println(tno);
        System.out.println("hdghghjg");

        String sql = "select * from teacher where tno = ?";
        Object[] objects = {tno};

        ResultSet resultSet = TeaDao.qureyInfo(sql, objects);
        ArrayList<Teacher> teaArrayList = new ArrayList<Teacher>();
        try {
            while (resultSet.next()){
                Teacher teacher = new Teacher();
                teacher.setTno(resultSet.getString("tno"));
                teacher.setTname(resultSet.getString("tname"));
                teacher.setTsex(resultSet.getString("tsex"));
                teacher.setTage(resultSet.getInt("tage"));
                teacher.setTdept(resultSet.getString("tdept"));
                teacher.setTphone(resultSet.getString("tphone"));
                teacher.setTpsw(resultSet.getString("tpsw"));
                teaArrayList.add(teacher);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(resultSet);
        }

        System.out.println(teaArrayList);

        req.setAttribute("teaArrayList", teaArrayList);

        req.getRequestDispatcher("/view/tea/teainfo.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
