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
    <title>查询教师信息</title>
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

    <script type="text/javascript">
        function deleteTea(tno) {
            //用户安全提示
            if (confirm("您确定要删除吗?")){
                location.href = "${pageContext.request.contextPath}/DeptDeleteTeaServlet?tno=" + tno;
            }
        }

        window.onload = function () {
            //给删除选择按钮添加事件
            document.getElementById("delSelected").onclick = function () {
                //用户安全提示
                if (confirm("您确定要删除选中条目吗?")){
                    var flag = false;
                    var checkBoxs = document.getElementsByName("tno");
                    for (var i = 0; i < checkBoxs.length; i++){
                        //检查是否有复选框选中
                        if (checkBoxs[i].checked) {
                            flag = true;
                            break;
                        }
                    }
                    //如果有复选框被选中
                    if (flag){
                        //表单提交
                        document.getElementById("form").submit();
                    }
                }
            }

            //获取第一个复选框
            document.getElementById("firstCb").onclick = function () {
                //获取下面所有的复选框
                var checkBoxs = document.getElementsByName("tno");
                //遍历
                for (var i = 0; i < checkBoxs.length; i++){
                    //设置这些复选框的状态 = 第一个复选框的状态
                    checkBoxs[i].checked = this.checked;
                }
            }
        }

    </script>
</head>
<body>
     <br>
     <div class="pull-left">
         <form class="form-inline" action="${pageContext.request.contextPath}/DeptQueryTeaByPageServlet?currentPage=1&rows=7" method="post">
             <div class="form-group">
                 <label for="inputTno">教工号</label>
                 <input type="text" name="tno" value="${tno}" class="form-control" id="inputTno" placeholder="输入教工号查找">
             </div>
             <div class="form-group">
                 <label for="inputTName">姓名</label>
                 <input type="text" name="tname" value="${tname}" class="form-control" id="inputTName" placeholder="输入教师姓名查找">
             </div>
             <div class="form-group">
                 <label for="inputTSex">性别</label>
                 <input type="text" name="tsex" value="${tsex}" class="form-control" id="inputTSex" placeholder="输入性别查找">
             </div>
             <button type="submit" class="btn btn-primary">查询</button>
         </form>
     </div>
     <div class="pull-right">
         <a class="btn btn-default" href="${pageContext.request.contextPath}/view/deptadmin/addtea.jsp">添加教师</a>
         <a class="btn btn-danger" href="javascript:void(0);" id="delSelected">删除选中</a>
     </div>

    <form id="form" action="${pageContext.request.contextPath}/DeptDelSelectedTeaServlet" method="post">
        <%--条纹表格,通过添加 .table-striped class，您将在 <tbody> 内的行上看到条纹--%>
        <table class="table table-striped table-hover">
            <caption>
                本学院教师信息
               <%-- <div class="pull-right">
                    <a class="btn btn-default" href="${pageContext.request.contextPath}/view/deptadmin/addtea.jsp">添加教师</a>
                    <a class="btn btn-danger" href="javascript:void(0);" id="delSelected">删除选中</a>
                </div>--%>
            </caption>
            <thead style="background: #337ab7">
            <tr>
                <th><input type="checkbox" id="firstCb"></th>
                <th>编号</th>
                <th>教工号</th>
                <th>姓名</th>
                <th>性别</th>
                <th>年龄</th>
                <th>学院</th>
                <th>手机号</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${pageBean.arrayList}" var="teacher" varStatus="s">
                <tr>
                    <td><input type="checkbox" name="tno" value="${teacher.tno}"></td>
                    <td>${s.count}</td>
                    <td>${teacher.tno}</td>
                    <td>${teacher.tname}</td>
                    <td>${teacher.tsex}</td>
                    <td>${teacher.tage}</td>
                    <td>${teacher.tdept}</td>
                    <td>${teacher.tphone}</td>
                    <td>
                        <a class="btn btn-default" href="${pageContext.request.contextPath}/DeptQueryTeaByIdServlet?tno=${teacher.tno}">修改</a>
                        <a class="btn btn-danger"  href="javascript:deleteTea('${teacher.tno}');">删除</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </form>


     <div>
         <nav aria-label="Page navigation" class="pull-left">
             <ul class="pagination">
                 <c:if test="${pageBean.currentPage == 1}">
                 <li class="disabled">
                     </c:if>
                     <c:if test="${pageBean.currentPage != 1}">
                 <li>
                     </c:if>
                     <a href="${pageContext.request.contextPath}/DeptQueryTeaByPageServlet?currentPage=${pageBean.currentPage - 1}&rows=7&tno=${tno}&tname=${tname}&tsex=${tsex}" aria-label="Previous">
                         <span aria-hidden="true">&laquo;</span>
                     </a>
                 </li>

                 <c:forEach begin="1" end="${pageBean.totalPage}" var="i">
                     <c:if test="${pageBean.currentPage == i}">
                         <li class="active"><a href="${pageContext.request.contextPath}/DeptQueryTeaByPageServlet?currentPage=${i}&rows=7&tno=${tno}&tname=${tname}&tsex=${tsex}">${i}</a></li>
                     </c:if>
                     <c:if test="${pageBean.currentPage != i}">
                         <li><a href="${pageContext.request.contextPath}/DeptQueryTeaByPageServlet?currentPage=${i}&rows=7&tno=${tno}&tname=${tname}&tsex=${tsex}">${i}</a></li>
                     </c:if>

                 </c:forEach>

                 <c:if test="${pageBean.currentPage == pageBean.totalPage}">
                 <li class="disabled">
                     </c:if>
                     <c:if test="${pageBean.currentPage != pageBean.totalPage}">
                 <li>
                     </c:if>
                     <a href="${pageContext.request.contextPath}/DeptQueryTeaByPageServlet?currentPage=${pageBean.currentPage + 1}&rows=7&tno=${tno}&tname=${tname}&tsex=${tsex}" aria-label="Next">
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
