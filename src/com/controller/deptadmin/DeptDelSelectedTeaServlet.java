package com.controller.deptadmin;

import com.dao.DeptAdminDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeptDelSelectedTeaServlet")
public class DeptDelSelectedTeaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        //获取请求时复选框有选中的状态参数
        String[] tnos = req.getParameterValues("tno");

        System.out.println(tnos);

        if(tnos.length > 0 && tnos != null){
            //遍历并删除选中的sno,y一个一个删除
            for (String tno: tnos) {
                String sql = null;
                Object[] objects = {tno};

                //删除stupunchin中的该导游信息
                sql = "delete from teapunchin where tno = ?";
                int num1 = DeptAdminDao.executeUpdate(sql, objects);
                System.out.println(num1);

                //删除student表中该导游信息
                sql = "delete from teacher where tno = ?";
                int num2 = DeptAdminDao.executeUpdate(sql, objects);
                System.out.println(num2);
            }

            req.getRequestDispatcher("/DeptQueryTeaByPageServlet?currentPage=1&rows=7&tno=&tname=&tsex=").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
