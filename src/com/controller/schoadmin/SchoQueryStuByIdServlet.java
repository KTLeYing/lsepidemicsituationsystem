package com.controller.schoadmin;

import com.dao.DeptAdminDao;
import com.entity.Student;
import com.utils.JDBCUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;

@WebServlet("/SchoQueryStuByIdServlet")
public class SchoQueryStuByIdServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        String sno = req.getParameter("sno");

        String sql = null;
        Object[] objects = {sno};

        //查询是否存在此人
        sql = "select count(*) as num from student where sno = ?";
        int count = DeptAdminDao.findTotalCount(sql, objects);

        if (count > 0){ //有则继续操作
            sql = "select * from student where sno = ?";
            ResultSet resultSet = DeptAdminDao.qureyInfo(sql, objects);
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
                    student.setSpsw(resultSet.getString("spsw"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                JDBCUtils.close(resultSet);
            }

            System.out.println(student.getSsex());

            req.setAttribute("student", student);

            req.getRequestDispatcher("/view/schoadmin/alterstu.jsp").forward(req, resp);
        }else {
            req.getRequestDispatcher("/view/alluse/noexistdataofalter.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
