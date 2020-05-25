<%--
  Created by IntelliJ IDEA.
  User: 21989
  Date: 2020/4/9
  Time: 16:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>教师个人信息页面</title>
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
        .tb>tbody>tr>td{
            border: 0px solid #f1f1f1;
        }
        /*.core{
            width: 560px;
            height: 308px;
            margin-top: 222px;
            margin-left: 488px;
            !*background: #FCFCFC;*!
            background: rgba(252,252,252, 0.7);
            border-radius: 10px;
        }*/
        .core{
            position: absolute;
            left: 488px;
            top: 222px;
            width: 560px;
            height: 308px;
            /*background: #FCFCFC;*/
            background: rgba(252,252,252, 0.7);
            border-radius: 10px;
        }
        .but{
            position: absolute;
            right: 2px;
            top: 2px;
        }
    </style>
</head>
<body>
    <div class="core">
        <h3 style="font-weight: bold; padding-left: 20px">教师个人信息</h3>
        <br>
        <div style="padding-left: 15px">
            <table class="table tb">
                <tr>
                    <td width="350" height="90"><strong>教工号:</strong>${teacher.tno}</td>
                    <td width="200" height="90"><strong>姓名:</strong>${teacher.tname}</td>
                </tr>
                <tr>
                    <td width="350" height="90"><strong>性别:</strong>${teacher.tsex}</td>
                    <td width="200" height="90"><strong>年龄:</strong>${teacher.tage}</td>
                </tr>
                <tr>
                    <td width="350" height="90"><strong>学院:</strong>${teacher.tdept}</td>
                    <td width="200" height="90"><strong>手机号码:</strong>${teacher.tphone}</td>
                </tr>
            </table>
        </div>
    </div>

    <div class="but">
        <a class="btn btn-success btn-lg" href="${pageContext.request.contextPath}/view/frontweb/teapunch.jsp">教师打卡</a>
        <a class="btn btn-danger btn-lg" href="${pageContext.request.contextPath}/view/frontweb/teaalterpsw.jsp">修改密码</a>
        <a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/FrontWebServlet">返回首页</a>
    </div>
</body>
</html>
