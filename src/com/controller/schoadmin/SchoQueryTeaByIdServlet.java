package com.controller.schoadmin;

import com.dao.DeptAdminDao;
import com.entity.Teacher;
import com.utils.JDBCUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;

@WebServlet("/SchoQueryTeaByIdServlet")
public class SchoQueryTeaByIdServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        String tno = req.getParameter("tno");

        String sql = null;
        Object[] objects = {tno};

        System.out.println(tno);

        //查询是否存在此人
        sql = "select count(*) as num from teacher where tno = ?";
        int count = DeptAdminDao.findTotalCount(sql, objects);

        if (count > 0) { //有则继续操作
            sql = "select * from teacher where tno = ?";
            ResultSet resultSet = DeptAdminDao.qureyInfo(sql, objects);
            Teacher teacher = new Teacher();

            try {
                while (resultSet.next()){
                    teacher.setTno(resultSet.getString("tno"));
                    teacher.setTname(resultSet.getString("tname"));
                    teacher.setTsex(resultSet.getString("tsex"));
                    teacher.setTage(resultSet.getInt("tage"));
                    teacher.setTdept(resultSet.getString("tdept"));
                    teacher.setTphone(resultSet.getString("tphone"));
                    teacher.setTpsw(resultSet.getString("tpsw"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                JDBCUtils.close(resultSet);
            }

            System.out.println(teacher.getTsex());

            req.setAttribute("teacher", teacher);

            req.getRequestDispatcher("/view/schoadmin/altertea.jsp").forward(req, resp);

        }else {
            req.getRequestDispatcher("/view/alluse/noexistdataofalter.jsp").forward(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
