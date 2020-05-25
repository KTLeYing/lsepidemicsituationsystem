<%--
  Created by IntelliJ IDEA.
  User: 21989
  Date: 2020/4/10
  Time: 8:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学校管理员登录页面</title>
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
       /* .core{
            !*margin-left:475px;*!
            background: #FCFCFC;
            border-radius: 9px;
            margin-top: 65px;
            height: 295px;
        }*/
        .core{
            position: absolute;
            top: 274px;
            left: 512px;
            /*margin-left:475px;*/
            background: #FCFCFC;
            border-radius: 9px;
            height: 295px;
        }
        /*.head{
            width: 800px;
            height: 70px;
            margin-top: 140px;
            margin-left: 467px;
        }*/
        .head{
            position: absolute;
            top: 140px;
            left: 467px;
            width: 800px;
            height: 70px;
        }
        .head>p{
            text-shadow: 4px 4px 4px #7B7B7B;
            color: #5B5B5B;
        }
        .but{
            position: absolute;
            right: 2px;
            top: 2px;
        }
    </style>
</head>
<body>
    <div class="header-panel head">
        <p style="font-size: 50px"><strong>岭师疫情防控管理信息系统</strong></p>
    </div>

    <div class=" col-md-4 core">
        <h3 align="center" style="font-weight: bold">学校管理员登录</h3>
        <form action="${pageContext.request.contextPath}/SchoAdmLoginServlet" method="post">
            <div class="form-group">
                <label for="no" class="control-label">账号</label>
                <input type="text" class="form-control" required="required" placeholder="请输入管理员账号" id="no" name="adno">
            </div>
            <div class="form-group">
                <label for="psw" class="control-label">密码</label>
                <input type="password" class="form-control" required="required" placeholder="请输入密码" id="psw" name="adpsw" >
            </div>
            <div class="pull-right form-group">
                <a href="${pageContext.request.contextPath}/view/frontweb/schoadmforgetpsw.jsp">忘记密码</a>
            </div>
            <br>
            <div class="form-group" align="center" style="padding-left: 55px">
                <input type="submit" class="btn btn-success" value="登录" style="width: 100px">
                <input type="reset" class="btn btn-danger" value="重置" style="width: 100px">
            </div>
        </form>
    </div>

    <div class="but">
        <a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/FrontWebServlet">返回首页</a>
    </div>


</body>
</html>
