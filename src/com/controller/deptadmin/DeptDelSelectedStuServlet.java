package com.controller.deptadmin;

import com.dao.DeptAdminDao;
import com.utils.JDBCUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

@WebServlet("/DeptDelSelectedStuServlet")
public class DeptDelSelectedStuServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        //获取请求时复选框有选中的状态参数
        String[] snos = req.getParameterValues("sno");

        System.out.println(snos);

        if(snos.length > 0 && snos != null){
            //遍历并删除选中的sno,y一个一个删除
            for (String sno: snos) {
                String sql = null;
                Object[] objects = {sno};

                //删除stupunchin中的该导游信息
                sql = "delete from stupunchin where sno = ?";
                int num1 = DeptAdminDao.executeUpdate(sql, objects);
                System.out.println(num1);

                //删除student表中该导游信息
                sql = "delete from student where sno = ?";
                int num2 = DeptAdminDao.executeUpdate(sql, objects);
                System.out.println(num2);
            }

            req.getRequestDispatcher("/DeptQueryStuByPageServlet?currentPage=1&rows=7&sname=&sclass=&specialty=").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
