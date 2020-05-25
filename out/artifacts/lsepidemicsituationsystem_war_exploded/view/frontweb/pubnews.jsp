<%--
  Created by IntelliJ IDEA.
  User: 21989
  Date: 2020/4/12
  Time: 11:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员发布实时新闻</title>
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
            margin-top: 125px;
            !*margin-left: 488px;*!
            background: #FCFCFC;
            border-radius: 10px;
            height: 462px;
        }*/
        .core{
            position: absolute;
            top: 145px;
            left: 512px;
            /*margin-left: 488px;*/
            background: #FCFCFC;
            border-radius: 10px;
            height: 462px;
        }
        textarea{
            height: 80px;
            width: 480px;
            border-color: #E0E0E0;
            border-width: 1px;
            border-radius: 4px;
        }
    </style>

    <script type="text/javascript">
       function toback() {
            location.href = "${pageContext.request.contextPath}/view/schoadmin/schomainview.jsp"
        }
    </script>
</head>
<body>
     <br>
     <div class="core col-md-4" >
         <h3 align="center" style="font-weight: bold">发布实时新闻</h3>
         <form action="${pageContext.request.contextPath}/PubNewsServlet" method="post">
             <div class="form-group">
                 <label for="id" class="control-label">编号</label>
                 <input type="text" class="form-control" required="required" placeholder="请输入新闻编号" id="id" name="nid">
             </div>
             <div class="form-group">
                 <label for="title" class="control-label">标题</label><br>
                 <textarea name="title" id="title"  required="required" placeholder="请输入标题"></textarea>
             </div>
             <div class="form-group">
                 <label for="url" class="control-label">新闻来源</label><br>
                 <textarea name="url" id="url" required="required" placeholder="请输入文章来源"></textarea>
             </div>
             <div class="form-group"  align="center">
                 <br>
                 <input type="submit" class="btn btn-success" value="发布">
                 <input type="reset" class="btn btn-danger" value="重置">
                 <input type="button" class="btn btn-default" value="返回" onclick="javascript:toback();">
             </div>
         </form>
     </div>
</body>
</html>
