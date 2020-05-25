package com.controller.deptadmin;

import com.dao.DeptAdminDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeptDelSelectedStuPunchServlet")
public class DeptDelSelectedStuPunchServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        //获取请求时复选框有选中的状态参数
        String[] snodates = req.getParameterValues("snodates");

        System.out.println(snodates);

        if(snodates.length > 0 && snodates != null){
            //遍历并删除选中的sno,y一个一个删除
            for (String snodate: snodates) {

                //分离两个参数
                String[] params = snodate.split(",");
                String sno = params[0];
                String spunchdate = params[1];

                System.out.println(sno);
                System.out.println(spunchdate);

                //字符串转为日期类型
//        Date spunchdate1 = new Date(spunchdate);
                //或
//        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
//        Date spunchdate1 = ft.format(spunchdate);

                String sql = null;
                Object[] objects = {sno, spunchdate};

                //删除stupunchin中的该导游信息
                sql = "delete from stupunchin where sno = ? and spunchdate = ?";
                int num1 = DeptAdminDao.executeUpdate(sql, objects);
                System.out.println(num1);
            }

            req.getRequestDispatcher("/DeptQueryStuPunchByPageServlet?currentPage=1&rows=7&sname=&sclass=&spunchdate=").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
