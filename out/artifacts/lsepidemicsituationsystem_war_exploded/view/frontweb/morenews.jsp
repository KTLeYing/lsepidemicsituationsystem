<%--
  Created by IntelliJ IDEA.
  User: 21989
  Date: 2020/4/12
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>更多疫情新闻</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width， initial-scale=1" />
    <!-- 顺序：先css后jquery最好bootstrap.js -->
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style type="text/css">
        body{
            background: #88cbf8;
            /*background: url("/img/bg7.jpg");
            background-repeat: no-repeat;
            height: 100%;
            background-position: center;
            background-size: cover;*/
        }
        /*.title{
            position: absolute;
            top: 15px;
            height: 50px;
            width: 730px;
            margin-left: 15px;
        }*/
        .title{
            position: absolute;
            left: 403px;
            top: 15px;
            height: 50px;
            width: 730px;
        }
        /*.morenews{
            position: absolute;
            top: 70px;
            height: 655px;
            width: 730px;
            margin-left: 15px;
            overflow: scroll;
            !*background: #FCFCFC;*!
            background: rgba(252,252,252, 0.8);
            !*border-radius: 9px;*!
        }*/
        .morenews{
            position: absolute;
            left: 403px;
            top: 70px;
            height: 655px;
            width: 730px;
            overflow: scroll;
            /*background: #FCFCFC;*/
            background: rgba(252,252,252, 0.8);
            /*border-radius: 9px;*/
        }
        /*.but{
            position: absolute;
            right: 2px;
            top: 2px;
        }*/
        .but{
            position: absolute;
            right: 2px;
            top: 2px;
        }
    </style>
</head>
<body>
     <div class="container">
         <div class="col-md-offset-2">
             <div class="title">
                 <p style="font-size: 32px">疫情新闻播报</p>
             </div>
             <div class="morenews">
                 <div style="padding-top: 20px; padding-left: 20px">
                     <c:forEach items="${newsArrayList}" var="news" varStatus="s">
                         <%--                            <div style="width:20px;height:20px;border-radius:50%;background-color:red; float: left"></div>--%>
                         <a style="font-size: 17px; float: left; color: black" href="${news.url}">
                             <i class=" fa fa-hand-o-right" style="float: left"></i>
                             &nbsp;${news.title}&nbsp;&nbsp;&nbsp;
                             <i class="fa fa-angle-double-right"></i>
                         </a>
                         <p style="padding-top: 3px; color: #7B7B7B">
                             <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${news.pubdate}</span>
                         </p>
                         <br>
                     </c:forEach>
                 </div>
             </div>
         </div>
     </div>

     <div class="but">
         <a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/FrontWebServlet">返回首页</a>
     </div>

</body>
</html>
