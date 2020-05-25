package com.controller.schoadmin;

import com.dao.DeptAdminDao;
import com.dao.StuDao;
import com.entity.PageBean;
import com.entity.StuPunch;
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

@WebServlet("/SchoQueryStuPunchByPageServlet")
public class SchoQueryStuPunchByPageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        //获取请求参数
        String sname = req.getParameter("sname");
        String sclass = req.getParameter("sclass");
        String sdept = req.getParameter("sdept");
        String spunchdate = req.getParameter("spunchdate");

        System.out.println(sname);
        System.out.println(sclass);
        System.out.println(sdept);
        System.out.println(spunchdate);


        //如果传入的参数为null，则置为空字符串
        if (sname == null){
            sname = "";
        }
        if (sclass == null){
            sclass = "";
        }
        if (sdept == null){
            sdept = "";
        }
        if (spunchdate == null){
            spunchdate = "";
        }

        //变为like查询所需的字符串参数
        String sname1 = "%" + sname + "%";
        String sclass1 = "%" + sclass + "%";
        String sdept1 = "%" + sdept + "%";
        String spunchdate1 = "%" + spunchdate + "%";

        //设置请求的属性参数，后面需要用
        req.setAttribute("sname",sname);
        req.setAttribute("sclass", sclass);
        req.setAttribute("sdept", sdept);
        req.setAttribute("spunchdate",spunchdate);

        System.out.println(sname1);
        System.out.println(sclass1);
        System.out.println(sdept1);
        System.out.println(spunchdate1);

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
        PageBean<StuPunch> pageBean = new PageBean<StuPunch>();

        //设置当前页码
        pageBean.setCurrentPage(currentPage1);

        //设置每页的记录数
        pageBean.setRows(rows1);

        sql = " select count(*) as num from student s, stupunchin sp where s.sno = sp.sno and s.sname like ? and s.sclass like ? and s.sdept like ? and sp.spunchdate like ?";
        Object[] objects = {sname1, sclass1, sdept1, spunchdate1};

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
            sql = "select s.sname,s.sclass,s.sdept,sp.* from student s, stupunchin sp where s.sno = sp.sno and s.sname like ? and s.sclass like ? and s.sdept like ? and sp.spunchdate like ? limit ?, ?";
            Object[] objects1 = {sname1, sclass1, sdept1, spunchdate1, start, rows1};

            ResultSet resultSet = StuDao.QureyInfoByPage(sql, objects1);
            ArrayList stuPunchArrayList = new ArrayList();

            try {
                while (resultSet.next()){
                    StuPunch stuPunch = new StuPunch();
                    stuPunch.setSno(resultSet.getString("sno"));
                    stuPunch.setSname(resultSet.getString("sname"));
                    stuPunch.setSclass(resultSet.getString("sclass"));
                    stuPunch.setSdept(resultSet.getString("sdept"));
                    stuPunch.setSispunch(resultSet.getString("sispunch"));
                    stuPunch.setSpunchdate(resultSet.getDate("spunchdate"));
                    stuPunch.setSpunchtime(resultSet.getString("spunchtime"));
                    stuPunch.setSishot(resultSet.getString("sishot"));
                    stuPunch.setSiscough(resultSet.getString("siscough"));
                    stuPunch.setSisseem(resultSet.getString("sisseem"));
                    stuPunch.setSisdiagnose(resultSet.getString("sisdiagnose"));
                    stuPunch.setSstatus(resultSet.getString("sstatus"));
                    stuPunchArrayList.add(stuPunch);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                JDBCUtils.close(resultSet);
            }
            pageBean.setArrayList(stuPunchArrayList);

            System.out.println(stuPunchArrayList);
            System.out.println(pageBean);

            req.setAttribute("pageBean", pageBean);

            req.getRequestDispatcher("/view/schoadmin/stupunchlist.jsp").forward(req, resp);
        }else {
            req.getRequestDispatcher("/view/alluse/nodata.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
