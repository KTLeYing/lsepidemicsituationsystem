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
    <title>修改学生打卡信息页面</title>
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
            margin-top: 1px;
        }
    </style>
</head>
<body>
    <div class="col-md-3 core">
        <h3 align="center">修改学生打卡信息</h3>
        <form action="${pageContext.request.contextPath}/SchoAlterStuPunchServlet" method="post">
            <input type="hidden" name="sno" value="${stuPunch.sno}">
            <div class="form-group">
                <label for="inputName">姓名:</label>
                <input type="text" required="required" class="form-control" name="sname" value="${stuPunch.sname}" readonly="readonly" id="inputName" placeholder="请输入导游姓名">
            </div>
            <div class="form-group">
                <label for="inputpunch">是否已打卡:</label>
                <input type="text" list="list1" value="${stuPunch.sispunch}" required="required" class="form-control" name="sispunch" id="inputpunch" placeholder="请选择打卡情况">
                <datalist id="list1">
                    <option>是</option>
                    <option>否</option>
                </datalist>
            </div>
            <div class="form-group">
                <label for="inputdate">日期:</label>
                <input type="date"  value="${stuPunch.spunchdate}" class="form-control" name="spunchdate" readonly="readonly" id="inputdate" placeholder="请输入日期">
            </div>
            <div class="form-group">
                <label for="inputtime">打卡时间:</label>
                <input type="text" value="${stuPunch.spunchtime}" class="form-control" name="spunchtime" id="inputtime" placeholder="请输入打卡时间 -hh:mm-">
            </div>
            <div class="form-group">
                <label for="inputhot">是否发热:</label>
                <input type="text" list="list2" value="${stuPunch.sishot}"  class="form-control" name="sishot" id="inputhot" placeholder="请选择发热情况">
                <datalist id="list2">
                    <option>是</option>
                    <option>否</option>
                </datalist>
            </div>
            <div class="form-group">
                <label for="inputcough">是否咳嗽:</label>
                <input type="text" list="list3" value="${stuPunch.siscough}" class="form-control" name="siscough" id="inputcough" placeholder="请选择疑似病例情况">
                <datalist id="list3">
                    <option>是</option>
                    <option>否</option>
                </datalist>
            </div>
            <div class="form-group">
                <label for="inputseem">是否为疑似病例:</label>
                <input type="text" list="list5" value="${stuPunch.sisseem}" class="form-control" name="sisseem" id="inputseem" placeholder="请选择确诊病例情况">
                <datalist id="list5">
                    <option>是</option>
                    <option>否</option>
                </datalist>
            </div>
            <div class="form-group">
                <label for="inputsure">是否为确诊病例:</label>
                <input type="text" list="list6" value="${stuPunch.sisdiagnose}" class="form-control" name="sisdiagnose" id="inputsure" placeholder="请选择咳嗽情况">
                <datalist id="list6">
                    <option>是</option>
                    <option>否</option>
                </datalist>
            </div>
            <div class="form-group">
                <label for="inputstatus">状态:</label>
                <input type="text" list="list4" value="${stuPunch.sstatus}" class="form-control" name="sstatus" id="inputstatus" placeholder="请选择状态">
                <datalist id="list4">
                    <option>正常</option>
                    <option>异常</option>
                </datalist>
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
