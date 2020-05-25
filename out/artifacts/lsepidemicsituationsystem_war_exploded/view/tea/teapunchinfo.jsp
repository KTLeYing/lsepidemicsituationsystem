<%--
  Created by IntelliJ IDEA.
  User: 21989
  Date: 2020/3/3
  Time: 15:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>查询打卡信息</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width， initial-scale=1" />
   <%-- <link rel="stylesheet" href="bootstrap/bootstrap.min.css">
    <script src="bootstrap/bootstrap.min.js"></script>
    <script src="bootstrap/jquery-3.2.1.min.js"></script>--%>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <style type="text/css">
        td, th{
            text-align: center;
        }
    </style>
</head>
<body>
     <br>
     <div class="pull-left">
         <form class="form-inline" action="${pageContext.request.contextPath}/TeaQueryPunchByPageServlet?currentPage=1&rows=7" method="post">
             <div class="form-group">
                 <label for="inputDate">日期</label>
                 <input type="date" name="tpunchdate" value="${tpunchdate}" class="form-control" id="inputDate" placeholder="选择日期查找">
             </div>
             <button type="submit" class="btn btn-primary">查询</button>
         </form>
     </div>

     <%--条纹表格,通过添加 .table-striped class，您将在 <tbody> 内的行上看到条纹--%>
     <table class="table table-striped table-hover">
         <caption>教师打卡信息</caption>
         <thead style="background: #337ab7">
            <tr>
                <th>编号</th>
                <th>姓名</th>
                <th>是否打卡</th>
                <th>日期</th>
                <th>打卡时间</th>
                <th>发热</th>
                <th>咳嗽</th>
                <th>疑似病例</th>
                <th>确诊病例</th>
                <th>状态</th>
            </tr>
         </thead>
         <tbody>
              <c:forEach items="${pageBean.arrayList}" var="teaPunch" varStatus="s">
                  <tr>
                      <td>${s.count}</td>
                      <td>${teaPunch.tname}</td>
                      <td>${teaPunch.tispunch}</td>
                      <td>${teaPunch.tpunchdate}</td>
                      <td>${teaPunch.tpunchtime}</td>
                      <td>${teaPunch.tishot}</td>
                      <td>${teaPunch.tiscough}</td>
                      <td>${teaPunch.tisseem}</td>
                      <td>${teaPunch.tisdiagnose}</td>
                      <td>${teaPunch.tstatus}</td>
                  </tr>
              </c:forEach>
         </tbody>
     </table>

     <div>
         <nav aria-label="Page navigation" class="pull-left">
             <ul class="pagination">
                 <c:if test="${pageBean.currentPage == 1}">
                 <li class="disabled">
                     </c:if>
                     <c:if test="${pageBean.currentPage != 1}">
                 <li>
                     </c:if>
                     <a href="${pageContext.request.contextPath}/TeaQueryPunchByPageServlet?currentPage=${pageBean.currentPage - 1}&rows=7&tpunchdate=${tpunchdate}" aria-label="Previous">
                         <span aria-hidden="true">&laquo;</span>
                     </a>
                 </li>

                 <c:forEach begin="1" end="${pageBean.totalPage}" var="i">
                     <c:if test="${pageBean.currentPage == i}">
                         <li class="active"><a href="${pageContext.request.contextPath}/TeaQueryPunchByPageServlet?currentPage=${i}&rows=7&tpunchdate=${tpunchdate}">${i}</a></li>
                     </c:if>
                     <c:if test="${pageBean.currentPage != i}">
                         <li><a href="${pageContext.request.contextPath}/TeaQueryPunchByPageServlet?currentPage=${i}&rows=7&tpunchdate=${tpunchdate}">${i}</a></li>
                     </c:if>

                 </c:forEach>

                 <c:if test="${pageBean.currentPage == pageBean.totalPage}">
                 <li class="disabled">
                     </c:if>
                     <c:if test="${pageBean.currentPage != pageBean.totalPage}">
                 <li>
                     </c:if>
                     <a href="${pageContext.request.contextPath}/TeaQueryPunchByPageServlet?currentPage=${pageBean.currentPage + 1}&rows=7&tpunchdate=${tpunchdate}" aria-label="Next">
                         <span aria-hidden="true">&raquo;</span>
                     </a>
                 </li>

                 <span style="font-size: 23px; margin-left: 5px">共${pageBean.totalCount}条记录，共${pageBean.totalPage}页</span>
             </ul>
         </nav>

         <br>
         <a href="${pageContext.request.contextPath}/view/alluse/welcome.jsp" class="pull-right">
             <input type="button" class="btn-primary btn" value="返回首页">
         </a>
     </div>
</body>
</html>
