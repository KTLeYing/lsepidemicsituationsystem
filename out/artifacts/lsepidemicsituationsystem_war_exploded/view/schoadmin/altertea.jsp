<%--
  Created by IntelliJ IDEA.
  User: 21989
  Date: 2020/3/28
  Time: 0:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>修改教师信息页面</title>
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
            margin-left:475px;
            margin-top: 38px;
        }
    </style>
</head>
<body>
    <div class="col-md-3 core">
        <h3 align="center">修改教师信息</h3>
        <form action="${pageContext.request.contextPath}/SchoAlterTeaServlet" method="post">
            <input type="hidden" name="tno" value="${teacher.tno}">
            <div class="form-group">
                <label for="inputName">姓名:</label>
                <input type="text" required="required" class="form-control" name="tname" value="${teacher.tname}" readonly="readonly" id="inputName" placeholder="请输入导游姓名">
            </div>
            <div class="form-group form-horizontal">
                <label for="inputSex">性别:</label>
                <c:if test="${teacher.tsex == '男'}">
                    <input type="radio" name="tsex" value="男" id="inputSex" checked="checked"> 男 &nbsp;
                    <input type="radio" name="tsex" value="女" id="inputSex"> 女
                </c:if>
                <c:if test="${teacher.tsex == '女'}">
                    <input type="radio" name="tsex" value="男" id="inputSex" > 男 &nbsp;
                    <input type="radio" name="tsex" value="女" id="inputSex" checked="checked"> 女
                </c:if>
            </div>
            <div class="form-group">
                <label for="inputAge">年龄:</label>
                <input type="text" required="required" class="form-control" name="tage" value="${teacher.tage}" id="inputAge" placeholder="请输入年龄">
            </div>
            <div class="form-group">
                <label for="inputWorkYears">学院:</label>
                <input type="text" required="required" class="form-control" name="tdept" value="${teacher.tdept}" id="inputWorkYears" placeholder="请输入学院">
            </div>
            <div class="form-group">
                <label for="inputPhone">手机号:</label>
                <input type="text" required="required" class="form-control" name="tphone" value="${teacher.tphone}" id="inputPhone" placeholder="请输入手机号">
            </div>
            <div class="form-group">
                <label for="inputPassword">密码:</label>
                <input type="password" required="required" class="form-control" name="tpsw" value="${teacher.tpsw}" id="inputPassword" placeholder="请输入密码">
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
