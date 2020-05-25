<%--
  Created by IntelliJ IDEA.
  User: 21989
  Date: 2020/3/31
  Time: 11:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
       <%
          response.sendRedirect(request.getContextPath() + "/FrontWebServlet");
       %>
  </body>
</html>
