package com.controller.schoadmin;

import com.dao.DeptAdminDao;
import com.dao.StuDao;
import com.entity.PageBean;
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

@WebServlet("/SchoQueryTeaByPageServlet")
public class SchoQueryTeaByPageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        //获取请求参数
        String tno = req.getParameter("tno");
        String tname = req.getParameter("tname");
        String tdept = req.getParameter("tdept");


        //如果传入的参数为null，则置为空字符串
        if (tno == null){
            tno = "";
        }
        if (tname == null){
            tname = "";
        }
        if (tdept == null){
            tdept = "";
        }

        //变为like查询所需的字符串参数
        String tno1 = "%" + tno + "%";
        String tname1 = "%" + tname + "%";
        String tdept1 = "%" + tdept + "%";

        //设置请求的属性参数，后面需要用
        req.setAttribute("tno", tno);
        req.setAttribute("tname",tname);
        req.setAttribute("tdept",tdept);

        System.out.println(tno1);
        System.out.println(tname1);
        System.out.println(tdept1);

        //获取登录时的session会话对象
        HttpSession session = req.getSession();
//        String userName = (String) session.getAttribute("userName");
//        String sno = (String) session.getAttribute("sno");
        String belong = (String) session.getAttribute("belong");

        String sql = null;

//        System.out.println(userName);
//        System.out.println(sno);
        System.out.println(belong);
        System.out.println("hdghghjg");

        String currentPage = req.getParameter("currentPage");//从请求对象中获取当前页码
        String rows = req.getParameter("rows");//从请求获取对象中每页显示的行数

        //如果未设请求参数，此处自动设置参数为第一页
        if (currentPage == null || "".equals(currentPage)){
            currentPage = "1";
        }

        //如果没有设置rows的请求参数，此处自动设置
        if (rows == null || "".equals(rows)){
            rows = "7";
        }

        //获取条件查询的参数
        int currentPage1 = Integer.parseInt(currentPage);
        int rows1 = Integer.parseInt(rows);

        //如果当前页数小于1，则设置当前页数为1
        if (currentPage1 <= 0){
            currentPage1 = 1;
        }

        //设置StuPunch类的对象类型
        PageBean<Teacher> pageBean = new PageBean<Teacher>();

        //设置当前页码
        pageBean.setCurrentPage(currentPage1);

        //设置每页的记录数
        pageBean.setRows(rows1);

        sql = " select count(*) as num from teacher where tno like ? and tname like ? and tdept like ?";
        Object[] objects = {tno1, tname1, tdept1};

        //计算总记录数，并设置
        int totalCount = DeptAdminDao.findTotalCount(sql, objects);
        System.out.println(totalCount);
        pageBean.setTotalCount(totalCount);

        if (totalCount > 0){
            //计算总页码，并设置
            int totalPage = (totalCount % rows1) == 0 ? totalCount/rows1 : (totalCount/rows1 + 1);
            pageBean.setTotalPage(totalPage);

            //如果当前页数大于总页数
            if (currentPage1 > pageBean.getTotalPage()){
                currentPage1 = pageBean.getTotalPage();
                //重新设置当前页码
                pageBean.setCurrentPage(currentPage1);
            }

            //计算开始的记录和list对象集合，并设置
            int start = (currentPage1 - 1) * rows1;
            sql = "select * from teacher where tno like ? and tname like ? and tdept like ? limit ?, ?";
            Object[] objects1 = {tno1, tname1, tdept1, start, rows1};

            ResultSet resultSet = StuDao.QureyInfoByPage(sql, objects1);
            ArrayList teaArrayList = new ArrayList();

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
            pageBean.setArrayList(teaArrayList);

            System.out.println(teaArrayList);
            System.out.println(pageBean);

            req.setAttribute("pageBean", pageBean);

            req.getRequestDispatcher("/view/schoadmin/teainfolist.jsp").forward(req, resp);
        }else {
            req.getRequestDispatcher("/view/alluse/nodata.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
