<%--
  Created by IntelliJ IDEA.
  User: 21989
  Date: 2020/3/29
  Time: 20:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>删除学院学生信息页面</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width， initial-scale=1" />
    <!-- 顺序：先css后jquery最好bootstrap.js -->
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <style type="text/css">
        body{
            background: rgba(176,196,222, 0.2);
        }
        .core{
            margin-left:482px;
            margin-top: 198px;
        }
    </style>
</head>
<body>
      <div class="col-md-3 core">
          <h3 align="center">删除学院学生信息</h3>
          <br>
          <form action="${pageContext.request.contextPath}/DeptDeleteStuServlet1" method="post">
              <div class="form-group">
                  <label for="inputSno">学号:</label>
                  <input type="text" required="required" class="form-control" name="sno" id="inputSno" placeholder="请输入要删除的学生学号">
              </div>
              <div class="form-group" align="center">
                  <input type="submit" class="btn btn-success" value="提交">
                  <input type="reset" class="btn btn-primary" value="重置">
                  <input type="button" class="btn btn-default" value="返回" onclick="javascript:history.back(-1);">
              </div>
          </form>
      </div>
</body>
</html>
