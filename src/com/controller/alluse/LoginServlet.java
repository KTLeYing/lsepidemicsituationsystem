package com.controller.alluse;

import com.alibaba.druid.util.JdbcUtils;
import com.dao.SchoAdminDao;
import com.dao.StuDao;
import com.dao.TeaDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.ResultSet;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        String userName =  req.getParameter("userName");
        String psw =  req.getParameter("psw");
        String identity =  req.getParameter("identity1");
        System.out.println(userName);
        System.out.println(psw);
        System.out.println(identity);

        if (identity.equals("学生")){//学生身份
            boolean flag = false;
            String sql = "select * from student where sname = ? and spsw = ?";
            Object[] objects = {userName, psw};
                ResultSet resultSet = StuDao.login(sql, objects);
            String sno = null;
            try {
                if (resultSet.next()){
                    flag = true;
                    sno = resultSet.getString("sno");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                JdbcUtils.close(resultSet);
            }
            if (flag){
                System.out.println("登录成功!");
                //创建会话，处理请求要用
                HttpSession session = req.getSession();
                session.setAttribute("userName", userName);
                // 创建请求属性对象，处理请求要用
                session.setAttribute("sno", sno);
                System.out.println(sno);

                req.setAttribute("httpUrl","/view/stu/stumainview.jsp");
                req.setAttribute("info", "登录成功!即将跳转至后台首页!");
                req.setAttribute("title","登录成功");
                req.getRequestDispatcher("/view/alluse/info.jsp").forward(req, resp);
//                resp.sendRedirect(req.getContextPath() + "/view/stu/stumainview.jsp");
            }else {
                System.out.println("用户名或密码错误!请重新登录!");
                //返回登录成功的信息
                req.setAttribute("httpUrl","/view/login/login.jsp");
                req.setAttribute("info", "登录失败!用户名或密码错误!即将跳转至登录页面!");
                req.setAttribute("title","登录失败");
                req.getRequestDispatcher("/view/alluse/info.jsp").forward(req, resp);
            }
        }else
            if (identity.equals("教师")){//教师身份
            boolean flag = false;
            String sql = "select * from teacher where tname = ? and tpsw = ?";
            Object[] objects = {userName, psw};
            ResultSet resultSet = TeaDao.login(sql, objects);
            String tno = null;
            try {
                if (resultSet.next()){
                    flag = true;
                    tno = resultSet.getString("tno");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                JdbcUtils.close(resultSet);
            }
            if (flag){
                System.out.println("登录成功!");
                //创建会话，处理请求要用
                HttpSession session = req.getSession();
                session.setAttribute("userName", userName);
                // 创建请求属性对象，处理请求要用
                session.setAttribute("tno", tno);
                System.out.println(tno);

                req.setAttribute("httpUrl","/view/tea/teamainview.jsp");
                req.setAttribute("info", "登录成功!即将跳转至后台首页!");
                req.setAttribute("title","登录成功");
                req.getRequestDispatcher("/view/alluse/info.jsp").forward(req, resp);
//                resp.sendRedirect(req.getContextPath() + "/view/guide/mainview_guide.jsp");
            }else {
                System.out.println("用户名或密码错误!请重新登录!");
                //返回登录成功的信息
                req.setAttribute("httpUrl","/view/login/login.jsp");
                req.setAttribute("info", "登录失败!用户名或密码错误!即将跳转至登录页面!");
                req.setAttribute("title","登录失败");
                req.getRequestDispatcher("/view/alluse/info.jsp").forward(req, resp);
            }
        }else {//如果是管理员
                boolean flag = false;
                String sql = "select * from admin where adname = ? and adpsw = ? and belong = ?";
                Object[] objects = {userName, psw, identity};
                ResultSet resultSet = SchoAdminDao.login(sql, objects);
//                String belong = null;
                try {
                    if (resultSet.next()){
                        flag = true;
//                        belong = resultSet.getString("belong");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    JdbcUtils.close(resultSet);
                }

                if (flag){

                    if (identity.equals("学校")){//学校管理员
                        System.out.println("登录成功!");
                        HttpSession session = req.getSession();
                        // 创建会话属性对象，处理请求要用
                        session.setAttribute("belong", identity);
                        System.out.println(identity);
//                        session.setAttribute("belong", belong);
//                        System.out.println(belong);

                        req.setAttribute("httpUrl","/view/schoadmin/schomainview.jsp");
                        req.setAttribute("info", "登录成功!即将跳转至后台首页!");
                        req.setAttribute("title","登录成功");
                        req.getRequestDispatcher("/view/alluse/info.jsp").forward(req, resp);
                    }else {//二级学院管理员
                        System.out.println("登录成功!");
                        //创建会话，处理请求要用
                        HttpSession session = req.getSession();
                        // 创建请求属性对象，处理请求要用
                        session.setAttribute("belong", identity);
                        System.out.println(identity);

                        req.setAttribute("httpUrl","/view/deptadmin/deptmainview.jsp");
                        req.setAttribute("info", "登录成功!即将跳转至后台首页!");
                        req.setAttribute("title","登录成功");
                        req.getRequestDispatcher("/view/alluse/info.jsp").forward(req, resp);
//                resp.sendRedirect(req.getContextPath() + "/view/guide/mainview_guide.jsp");
                    }

                }else {
                    System.out.println("用户名或密码错误!请重新登录!");
                    //返回登录成功的信息
                    req.setAttribute("httpUrl","/view/login/login.jsp");
                    req.setAttribute("info", "登录失败!用户名或密码错误!即将跳转至登录页面!");
                    req.setAttribute("title","登录失败");
                    req.getRequestDispatcher("/view/alluse/info.jsp").forward(req, resp);
                }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
