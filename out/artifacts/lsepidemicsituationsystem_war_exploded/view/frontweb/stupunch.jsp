<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: 21989
  Date: 2020/3/28
  Time: 0:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生打卡页面</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width， initial-scale=1" />
    <!-- 顺序：先css后jquery最好bootstrap.js -->
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <style type="text/css">
        body{
            /*background: #10aeb5*/
            background: #88cbf8;
        }
        /*.core{
            !*margin-left:475px;*!
            background: #FCFCFC;
            border-radius: 9px;
            margin-top: 40px;
            height: 500px;
        }*/
        .core{
            position: absolute;
            top: 190px;
            left: 512px;
            /*margin-left:475px;*/
            background: #FCFCFC;
            border-radius: 9px;
            height: 500px;
        }
        /*.head{
            width: 800px;
            height: 70px;
            margin-top: 40px;
            margin-left: 439px;
        }*/
        .head{
            position: absolute;
            left: 439px;
            top: 80px;
            width: 800px;
            height: 70px;
        }
        .head>p{
            text-shadow: 4px 4px 4px #7B7B7B;
            color: #5B5B5B;
        }
        .date{
            width: 200px;
            height: 40px;
            /*background: #FCFCFC;*/
        }
    </style>

    <script type="text/javascript">
        /*function toback() {
            location.href = "${pageContext.request.contextPath}/FrontWebServlet"
        }*/
    </script>
</head>
<body>
    <%
        Date date=new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        String now = sf.format(date);
    %>
    <div class="date">
        <p style="font-size: 25px; color: #5B5B5B">日期:<%= now%></p>
    </div>
    <div class="header-panel head">
        <p style="font-size: 47px"><strong>岭南师范学院疫情防控健康登记</strong></p>
    </div>

    <div class="col-md-4 core">
        <h3 align="center" style="font-weight: bold">学生打卡</h3>
        <form action="${pageContext.request.contextPath}/StuPunchServlet" method="post">
            <%--<div class="form-group">
                <label for="inputId">学号:</label>
                <input type="text" required="required" class="form-control" name="sno" id="inputId" placeholder="请输入学号">
            </div>--%>
            <div class="form-group">
                <label for="inputhot">是否发热:</label>
                <input type="text" list="list2"  class="form-control" required="required" name="sishot" id="inputhot" placeholder="请选择发热情况">
                <datalist id="list2">
                    <option>是</option>
                    <option>否</option>
                </datalist>
            </div>
            <div class="form-group">
                <label for="inputcough">是否咳嗽:</label>
                <input type="text" list="list3" class="form-control" required="required" name="siscough"  id="inputcough" placeholder="请选择咳嗽情况">
                <datalist id="list3">
                    <option>是</option>
                    <option>否</option>
                </datalist>
            </div>
            <div class="form-group">
                <label for="inputseem">是否为疑似病例:</label>
                <input type="text" list="list5" class="form-control" required="required" name="sisseem"  id="inputseem" placeholder="请选择疑似病例情况">
                <datalist id="list5">
                    <option>是</option>
                    <option>否</option>
                </datalist>
            </div>
            <div class="form-group">
                <label for="inputsure">是否为确诊病例:</label>
                <input type="text" list="list6" class="form-control" required="required" name="sisdiagnose"  id="inputsure" placeholder="请选择确诊病例情况">
                <datalist id="list6">
                    <option>是</option>
                    <option>否</option>
                </datalist>
            </div>
            <div class="form-group">
                <label for="inputstatus">状态:</label>
                <input type="text" list="list4" class="form-control" required="required" name="sstatus" id="inputstatus" placeholder="请选择健康状态">
                <datalist id="list4">
                    <option>正常</option>
                    <option>异常</option>
                </datalist>
            </div>
            <div class="form-group" align="center">
                <input type="submit" class="btn btn-success" value="提交">
                <input type="reset" class="btn btn-primary" value="重置">
                <input type="button" class="btn btn-default" value="返回" onclick="javascript:history.back(-1);" <%--onclick="javascript:toback();"--%>>
            </div>
        </form>
    </div>

</body>
</html>
