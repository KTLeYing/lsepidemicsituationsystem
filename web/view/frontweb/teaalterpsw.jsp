<%--
  Created by IntelliJ IDEA.
  User: 21989
  Date: 2020/4/9
  Time: 18:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>教师修改密码页面</title>
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
            margin-top: 230px;
            !*margin-left: 488px;*!
            background: #FCFCFC;
            border-radius: 10px;
            height: 290px;
        }*/
        .core{
            position: absolute;
            left: 512px;
            top: 230px;
            /*margin-left: 488px;*/
            background: #FCFCFC;
            border-radius: 10px;
            height: 290px;
        }
    </style>
    <script type="text/javascript">
        function toback() {
            location.href = "${pageContext.request.contextPath}/TeaInfoServlet"
        }
    </script>
</head>
<body>
     <div class="core col-md-4" >
         <h3 align="center" style="font-weight: bold">修改密码</h3>
         <form action="${pageContext.request.contextPath}/TeaAlterPswServlet" method="post">
             <div class="form-group">
                 <label for="psw" class="control-label">新密码</label>
                 <input type="password" class="form-control" required="required" placeholder="请输入新密码" id="psw" name="tpsw">
             </div>
             <div class="form-group">
                 <label for="psw1" class="control-label">确定密码</label>
                 <input type="password" class="form-control" required="required" placeholder="请再一次输入新密码" id="psw1" name="tpsw1" >
             </div>
             <div class="form-group"  align="center">
                 <br>
                 <input type="submit" class="btn btn-success" value="提交">
                 <input type="reset" class="btn btn-danger" value="重置">
                 <input type="button" class="btn btn-default" value="返回" onclick="javascript:toback();">
             </div>
         </form>
     </div>
</body>
</html>
