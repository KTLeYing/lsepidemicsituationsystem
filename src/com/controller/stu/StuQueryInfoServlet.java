package com.controller.stu;

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

@WebServlet("/StuQueryInfoServlet")
public class StuQueryInfoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        HttpSession session = req.getSession();
        String userName = (String) session.getAttribute("userName");
        String sno = (String) session.getAttribute("sno");

        System.out.println(userName);
        System.out.println(sno);
        System.out.println("hdghghjg");

        String sql = "select * from student where sno = ?";
        Object[] objects = {sno};

        ResultSet resultSet = StuDao.qureyInfo(sql, objects);
        ArrayList<Student> stuArrayList = new ArrayList<Student>();
        try {
            while (resultSet.next()){
                Student student = new Student();
                student.setSno(resultSet.getString("sno"));
                student.setSname(resultSet.getString("sname"));
                student.setSsex(resultSet.getString("ssex"));
                student.setSage(resultSet.getInt("sage"));
                student.setSclass(resultSet.getString("sclass"));
                student.setSpecialty(resultSet.getString("specialty"));
                student.setSdept(resultSet.getString("sdept"));
                student.setSphone(resultSet.getString("sphone"));
                student.setSpsw(resultSet.getString("spsw"));
                stuArrayList.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(resultSet);
        }

        System.out.println(stuArrayList);

        req.setAttribute("stuArrayList", stuArrayList);

        req.getRequestDispatcher("/view/stu/stuinfo.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
