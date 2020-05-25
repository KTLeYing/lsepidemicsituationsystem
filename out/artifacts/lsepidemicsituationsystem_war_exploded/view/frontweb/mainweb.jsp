<%--
  Created by IntelliJ IDEA.
  User: 21989
  Date: 2020/4/7
  Time: 20:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>岭师新冠肺炎疫情实时动态播报</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width， initial-scale=1" />
    <!-- 顺序：先css后jquery最好bootstrap.js -->
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <style type="text/css">
        body{
            /*background: #10aeb5;*/
            background: #88cbf8;
        }
        .panel1{
            z-index: 1000;
            position: absolute;
            top: 280px;
            height: 485px;
            width: 730px;
            /*background: #FCFCFC;*/
            background: rgba(252,252,252, 0.8);
            border-radius: 9px;
            margin-left: 15px;
        }
        .panel2{
            z-index: 1000;
            position: absolute;
            top: 2px;
            height: 350px;
            width: 300px;
            /*background: #f1f1f1;*/
            border-radius: 9px;
            margin-left: 510px;
        }
        .panel3{
            z-index: 1000;
            position: absolute;
            top: 112px;
            height: 100px;
            width: 450px;
            /*background: #f1f1f1;*/
            border-radius: 9px;
            margin-left: 30px;
        }
        .tb1>tbody>tr>td{
            border: 0px solid #f1f1f1;
        }
        .tb2>tbody>tr>td{
            height: 60px;
            vertical-align: middle;
        }
        .piechart{
            position: absolute;
            top: 823px;
            height: 534px;
            width: 730px;
            margin-left: 15px;
            /*background: #FCFCFC;*/
            background: rgba(252,252,252, 0.8);
            border-radius: 9px;
        }
        .barchart{
            position: absolute;
            top: 1419px;
            height: 534px;
            width: 730px;
            margin-left: 15px;
            /*background: #FCFCFC;*/
            background: rgba(252,252,252, 0.8);
            border-radius: 9px;
        }
        .panel4{
            position: absolute;
            top: 2010px;
            height: 60px;
            width: 730px;
            margin-left: 15px;
        }
        .panel5{
            position: absolute;
            top: 2070px;
            height: 1150px;
            width: 730px;
            background: #FCFCFC;
            border: 2px solid #d0d0d0 ;
            margin-left: 15px;
        }
        .panel6{
            position: absolute;
            top: 3270px;
            height: 60px;
            width: 730px;
            margin-left: 15px;
        }
        .panel7{
            position: absolute;
            top: 3330px;
            height: 1150px;
            width: 730px;
            background: #FCFCFC;
            border: 2px solid #d0d0d0 ;
            margin-left: 15px;
        }
        .newstitle{
            position: absolute;
            top: 4530px;
            height: 60px;
            width: 730px;
            margin-left: 15px;
        }
        .news{
            position: absolute;
            top: 4585px;
            height: 440px;
            width: 730px;
            margin-left: 15px;
            /*background: #FCFCFC;*/
            background: rgba(252,252,252, 0.8);
            border-radius: 9px;
        }
        .morenews{
            position: absolute;
            bottom: 0px;
            right: 0px;
            height: 50px;
            width: 150px;
        }
        .panel8{
            position: absolute;
            top: 5070px;
            height: 50px;
            width: 730px;
            /*background: #FCFCFC;*/
            background: rgba(252,252,252, 0.8);
            border-radius: 9px;
            margin-left: 15px;
        }
        .panel9{
            position: absolute;
            top: 5150px;
            height: 170px;
            width: 300px;
            /*background: #FCFCFC;*/
            border-radius: 9px;
            margin-left: 230px;
        }
        .footer2{
            width: 100%;
            height: 40px;
            /*background: rgba(252,252,252,0.5);*/
            background: #F0F0F0;
        }
    </style>

    <script type="text/javascript">
        $(function () { $('.tooltip-show').tooltip();});
    </script>
</head>
<body>
<%
    Date date=new Date();
    SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    String now = sf.format(date);
%>
<div class="container">
    <div class="col-md-offset-2">
        <div class="row">
            <img src="img/bg3.jpg" height="450" width="788">
        </div>

        <div class="panel1">
            <br>
            <p style="font-size: 30px; padding-left: 30px" >学校疫情数据统计</p>
            <br>
            <table class="table text-center tb1">
                <tbody>
                <tr>
                    <td height="150">
                        <h3 style="font-weight:600">打卡</h3>
                        <p style="font-size: 38px; color: orange"><strong>${allPunNum}</strong></p>
                    </td>
                    <td height="150">
                        <h3 style="font-weight:600">发烧</h3>
                        <p style="font-size: 38px; color: brown"><strong>${allHotNum}</strong></p>
                    </td>
                    <td height="150">
                        <h3 style="font-weight:600">咳嗽</h3>
                        <p style="font-size: 38px; color: #FFD306"><strong>${allCoughNum}</strong></p>
                    </td>
                </tr>
                <tr>
                    <td height="150">
                        <h3 style="font-weight:600">疑似病例</h3>
                        <p style="font-size: 38px; color: #4F9D9D"><strong>${allSeemNum}</strong></p>
                    </td>
                    <td height="150">
                        <h3 style="font-weight:600">确诊病例</h3>
                        <p style="font-size: 38px; color: red"><strong>${allDiagNum}</strong></p>
                    </td>
                    <td height="150">
                        <h3 style="font-weight:600">健康异常</h3>
                        <p style="font-size: 38px; color: #000079"><strong>${allStatusNum}</strong></p>
                    </td>
                </tr>
                </tbody>
            </table>
            <hr style="border-top:2px solid #A9A9A9;" width="100%" color="#987cb9" size=1>
            <p style="font-size: 25px; color: #808080; padding-left: 30px">截至时间<%= now%></p>
        </div>

        <div class="panel3">
            <h1 style="font-size: 52px; color: white; font-weight: bold">科学防护 共渡难关</h1>
            <h2 style="color: white">岭师疫情实时动态播报</h2>
        </div>

        <div class="panel2">
            <div>
                <div class="btn-group">
                    <a class="btn btn-success btn-lg dropdown-toggle" data-toggle="dropdown">
                        登录打卡
                        <span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu" role="menu">
                        <li>
                            <a href="${pageContext.request.contextPath}/view/frontweb/stulogin.jsp" class="tooltip-show" data-toggle="tooltip" title="登录打卡并查看学生信息">学生</a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/view/frontweb/tealogin.jsp" class="tooltip-show" data-toggle="tooltip" title="登录打卡并查看教师信息">教师</a>
                        </li>
                        <%--<li>
                            <a href="#" class="tooltip-show" data-toggle="tooltip" title="登录操作系统后台信息">管理员</a>
                        </li>--%>
                    </ul>
                </div>
                <div class="btn-group">
                    <a class="btn btn-primary btn-lg dropdown-toggle" data-toggle="dropdown">
                        管理员登录
                        <span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu" role="menu">
                        <li>
                            <a href="${pageContext.request.contextPath}/view/frontweb/schoadmlogin.jsp" class="tooltip-show" data-toggle="tooltip" title="登录操作后台学校信息" >学校管理员</a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/view/frontweb/deptadmlogin.jsp" class="tooltip-show" data-toggle="tooltip" title="登录操作后台二级学院信息">二级学院管理员</a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>

        <div class="piechart">
            <div align="center" style="padding-top: 20px">
                <img src="${graphUrl}" height="500" width="730">
            </div>
        </div>

        <div class="barchart">
            <div align="center" style="padding-top: 20px">
                <img src="${graphUrl1}" height="500" width="730">
            </div>
        </div>

        <div class="panel4">
            <p style="font-size: 32px; padding-left: 3px" >各学院学生情况统计</p>
        </div>

        <div class="panel5">
            <table class="table table-hover table-striped text-center tb2">
                <tbody>
                <tr style="background:#eeeeee">
                    <th height="60" class="text-center" style="vertical-align: middle;font-size: 25px" >学院</th>
                    <th height="60" class="text-center" style="vertical-align: middle;font-size: 25px" >发烧</th>
                    <th height="60" class="text-center" style="vertical-align: middle;font-size: 25px" >咳嗽</th>
                    <th height="60" class="text-center" style="vertical-align: middle;font-size: 25px" >疑似病例</th>
                    <th height="60" class="text-center" style="vertical-align: middle;font-size: 25px;color: red" >确诊病例</th>
                    <th height="60" class="text-center" style="vertical-align: middle;font-size: 25px" >异常</th>
                </tr>
                <c:forEach items="${webStuArrayList}" var="webStu" varStatus="s">
                    <tr>
                        <td style="font-weight: bold">${webStu.sdept}</td>
                        <td>${webStu.sishotNum}</td>
                        <td>${webStu.siscoughNum}</td>
                        <td>${webStu.sisseemNum}</td>
                        <td style="color: red">${webStu.sisdiagnoseNum}</td>
                        <td>${webStu.sstatusNum}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>

        <div class="panel6">
            <p style="font-size: 32px; padding-left: 3px" >各学院教师情况统计</p>
        </div>

        <div class="panel7">
            <table class="table table-hover table-striped text-center tb2">
                <tbody>
                <tr style="background:#eeeeee">
                    <th height="60" class="text-center" style="vertical-align: middle;font-size: 25px" >学院</th>
                    <th height="60" class="text-center" style="vertical-align: middle;font-size: 25px" >发烧</th>
                    <th height="60" class="text-center" style="vertical-align: middle;font-size: 25px" >咳嗽</th>
                    <th height="60" class="text-center" style="vertical-align: middle;font-size: 25px" >疑似病例</th>
                    <th height="60" class="text-center" style="vertical-align: middle;font-size: 25px; color: red" >确诊病例</th>
                    <th height="60" class="text-center" style="vertical-align: middle;font-size: 25px" >异常</th>
                </tr>
                <c:forEach items="${webTeaArrayList}" var="webTea" varStatus="s">
                    <tr>
                        <td style="font-weight: bold">${webTea.tdept}</td>
                        <td>${webTea.tishotNum}</td>
                        <td>${webTea.tiscoughNum}</td>
                        <td>${webTea.tisseemNum}</td>
                        <td style="color: red">${webTea.tisdiagnoseNum}</td>
                        <td>${webTea.tstatusNum}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>

        <div class="newstitle">
            <p style="font-size: 32px; padding-left: 3px">最新实时播报</p>
        </div>

        <div class="news">
            <div style="padding-top: 20px; padding-left: 20px">
                <c:forEach items="${newsArrayList}" var="news" varStatus="s">
                    <a style="font-size: 17px; float: left; color: black" href="${news.url}">
                        <i class=" fa fa-hand-o-right" style="float: left"></i>
                        &nbsp;${news.title}&nbsp;&nbsp;&nbsp;
                        <i class="fa fa-angle-double-right"></i>
                    </a>
                    <p style="padding-top: 3px; color: #7B7B7B">
                        <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${news.pubdate}</span>
                    </p>
                    <br>
                </c:forEach>
            </div>

            <div class="morenews">
                <a style="color: #7B7B7B; font-size: 21px" href="${pageContext.request.contextPath}/MoreNewsServlet">查看更多 >></a>
            </div>
        </div>

        <div class="panel8 text-center">
            <p style="font-size: 20px; padding-top: 11px"><strong>积极防护，保护自己，戴口罩，勤洗手</strong></p>
        </div>

        <div class="panel9 text-center" style="color: #4F4F4F">
            <p>请各位老师和同学自觉做好防疫工作</p>
            <p>疫情防护，人人有责</p>
        </div>

        <footer class="navbar-fixed-bottom footer2">
            <div class="container">
                <div align="center" style="padding-top: 10px; color: #696969">
                    Copyright © 2020 MaYeHuang. All Rights Reserved.
                </div>
            </div>
        </footer>


    </div>
</div>


</body>
</html>
