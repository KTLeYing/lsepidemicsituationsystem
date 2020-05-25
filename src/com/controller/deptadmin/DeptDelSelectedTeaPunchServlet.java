package com.controller.deptadmin;

import com.dao.DeptAdminDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeptDelSelectedTeaPunchServlet")
public class DeptDelSelectedTeaPunchServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        //获取请求时复选框有选中的状态参数
        String[] tnodates = req.getParameterValues("tnodates");

        System.out.println(tnodates);

        if(tnodates.length > 0 && tnodates != null){
            //遍历并删除选中的sno,y一个一个删除
            for (String tnodate: tnodates) {

                //分离两个参数
                String[] params = tnodate.split(",");
                String tno = params[0];
                String tpunchdate = params[1];

                System.out.println(tno);
                System.out.println(tpunchdate);

                //字符串转为日期类型
//        Date spunchdate1 = new Date(spunchdate);
                //或
//        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
//        Date spunchdate1 = ft.format(spunchdate);

                String sql = null;
                Object[] objects = {tno, tpunchdate};

                //删除stupunchin中的该信息
                sql = "delete from teapunchin where tno = ? and tpunchdate = ?";
                int num1 = DeptAdminDao.executeUpdate(sql, objects);
                System.out.println(num1);
            }

            req.getRequestDispatcher("/DeptQueryTeaPunchByPageServlet?currentPage=1&rows=7&tno=&tname=&tpunchdate=").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
