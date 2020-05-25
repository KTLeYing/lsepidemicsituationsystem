<%--
  Created by IntelliJ IDEA.
  User: 21989
  Date: 2020/3/14
  Time: 15:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
    <meta charset="UTF-8">
    <!-- 顺序：先css后jquery最好bootstrap.js -->
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <style type="text/css">
        body{
            background:url("../../img/background.jpg");
            background-size: 100%;
            background-repeat: no-repeat;
        }

        .title{
            margin-top: 130px;
            margin-left: 70px;
        }
        .form{
            background: rgba(255,255,255,0.3);
            width: 400px;
            margin: 15px auto;
        }
        .fa{
            display: inline-block;
            top: 24px;
            left: 6px;
            position: relative;
            color:  #ccc;
        }
        input[type="text"], input[type="password"]{
            padding-left: 26px;
        }
        input[type="text"].identity{
            padding-left: 34px;
        }
        #style{
            font-weight: bold;
            text-shadow:0 -3px 2px #6A5ACD, 1px -5px 3px #7B68EE, -1px -6px 5px #9370DB, 1px -9px 9px #8A2BE2;
            font-style: oblique;
            letter-spacing: 6px;
            /*text-shadow: 1px 1px 1px lightgray;*/
            /*text-shadow: -1px -1px 1px #000, 1px 1px 1px #fff*/

        }
        .checkbox{
            margin-left: 21px;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="title row">
            <div class="col-md-offset-2">
                <h2 id="style">岭师疫情防控管理信息系统</h2>
            </div>
        </div>
        <form class="form row" action="${pageContext.request.contextPath}/LoginServlet" method="post">
            <div class="form-horizontal col-md-offset-3" id="login_form">
                <div class="col-md-offset-3">
                    <h3 class="form-title">登录</h3>
                </div>

                <div class="col-md-9">
                    <div class="form-group">
                        <i class="fa fa-user fa-lg"></i>
                        <input type="text" class="form-control" required="required" placeholder="请输入用户名" id="userName" name="userName" >
                    </div>
                    <div class="form-group">
                        <i class="fa fa-lock fa-lg"></i>
                        <input type="password" class="form-control" required="required" placeholder="请输入密码" id="password" name="psw" >
                    </div>
                    <div class="form-group">
                        <label class="checkbox">
                            <input type="checkbox" name="remember" value="1"/> 记住密码
                        </label>
                    </div>
                    <div class="form-group">
                        <i class="fa fa-lg fa-id-card"></i>
                        <input type="text" list="idList" class="form-control identity" required="required" placeholder="请选择身份" name="identity1" id="identity1" autofocus="autofocus" maxlength="20">
                        <datalist id="idList">
                            <option>学生</option>
                            <option>教师</option>
                            <option >学校</option>
                            <option>信息工程学院</option>
                            <option>外国语学院</option>
                            <option>文传学院</option>
                            <option>音舞院</option>
                            <option>体科院</option>
                        </datalist>
                    </div>
                    <div class="form-group">
                        <br>
                        <input type="submit" class="btn btn-success btn-lg btn-sm pull-left" value="登录">
                        <input type="reset" class="btn btn-danger btn-lg btn-sm pull-right" value="重置">
                    </div>

                </div>
            </div>
        </form>

        <div class="row footer">
            <div class="col-md-12">
                <div align="center" style="padding-top: 110px">
                    Copyright © 2018-2020 MaZhenLe
                </div>
            </div>
        </div>
    </div>

</body>
</html>
