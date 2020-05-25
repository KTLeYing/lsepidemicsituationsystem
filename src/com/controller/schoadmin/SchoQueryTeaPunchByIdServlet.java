package com.controller.schoadmin;

import com.dao.DeptAdminDao;
import com.entity.TeaPunch;
import com.utils.JDBCUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;

@WebServlet("/SchoQueryTeaPunchByIdServlet")
public class SchoQueryTeaPunchByIdServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        //获取请求参数
        String tno = req.getParameter("tno");
        String tpunchdate = req.getParameter("tpunchdate");

        String sql = null;
        Object[] objects = {tno, tpunchdate};

        //查询是否存在此人
        sql = "select count(*) as num from teapunchin where tno = ? and tpunchdate = ?";
        int count = DeptAdminDao.findTotalCount(sql, objects);

        if (count > 0){ //有则继续操作
            sql = "select t.tname,tp.* from teacher t,teapunchin tp where t.tno = tp.tno and tp.tno = ? and tp.tpunchdate = ?";
            ResultSet resultSet = DeptAdminDao.qureyInfo(sql, objects);
            TeaPunch teaPunch = new TeaPunch();

            try {
                while (resultSet.next()){
                    teaPunch.setTno(resultSet.getString("tno"));
                    teaPunch.setTname(resultSet.getString("tname"));
                    teaPunch.setTispunch(resultSet.getString("tispunch"));
                    teaPunch.setTpunchdate(resultSet.getDate("tpunchdate"));
                    teaPunch.setTpunchtime(resultSet.getString("tpunchtime"));
                    teaPunch.setTishot(resultSet.getString("tishot"));
                    teaPunch.setTiscough(resultSet.getString("tiscough"));
                    teaPunch.setTisseem(resultSet.getString("tisseem"));
                    teaPunch.setTisdiagnose(resultSet.getString("tisdiagnose"));
                    teaPunch.setTstatus(resultSet.getString("tstatus"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                JDBCUtils.close(resultSet);
            }

            System.out.println(teaPunch.getTno());
            System.out.println(teaPunch.getTname());

            req.setAttribute("teaPunch", teaPunch);

            req.getRequestDispatcher("/view/schoadmin/alterteapunch.jsp").forward(req, resp);
        }else {
            req.getRequestDispatcher("/view/alluse/noexistdataofalter.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
