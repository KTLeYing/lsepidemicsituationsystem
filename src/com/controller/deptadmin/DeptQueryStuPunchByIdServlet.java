package com.controller.deptadmin;

import com.dao.DeptAdminDao;
import com.entity.StuPunch;
import com.entity.Student;
import com.utils.JDBCUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;

@WebServlet("/DeptQueryStuPunchByIdServlet")
public class DeptQueryStuPunchByIdServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        //获取请求参数
        String sno = req.getParameter("sno");
        String spunchdate = req.getParameter("spunchdate");

        String sql = null;
        Object[] objects = {sno, spunchdate};

        //查询是否存在此人
        sql = "select count(*) as num from stupunchin where sno = ? and spunchdate = ?";
        int count = DeptAdminDao.findTotalCount(sql, objects);

        if (count > 0){ //有则继续操作
            sql = "select s.sname,sp.* from student s,stupunchin sp where s.sno = sp.sno and sp.sno = ? and sp.spunchdate = ?";
            ResultSet resultSet = DeptAdminDao.qureyInfo(sql, objects);
            StuPunch stuPunch = new StuPunch();

            try {
                while (resultSet.next()){
                    stuPunch.setSno(resultSet.getString("sno"));
                    stuPunch.setSname(resultSet.getString("sname"));
                    stuPunch.setSispunch(resultSet.getString("sispunch"));
                    stuPunch.setSpunchdate(resultSet.getDate("spunchdate"));
                    stuPunch.setSpunchtime(resultSet.getString("spunchtime"));
                    stuPunch.setSishot(resultSet.getString("sishot"));
                    stuPunch.setSiscough(resultSet.getString("siscough"));
                    stuPunch.setSisseem(resultSet.getString("sisseem"));
                    stuPunch.setSisdiagnose(resultSet.getString("sisdiagnose"));
                    stuPunch.setSstatus(resultSet.getString("sstatus"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                JDBCUtils.close(resultSet);
            }

            req.setAttribute("stuPunch", stuPunch);

            req.getRequestDispatcher("/view/deptadmin/alterstupunch.jsp").forward(req, resp);
        }else {
            req.getRequestDispatcher("/view/alluse/noexistdataofalter.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
