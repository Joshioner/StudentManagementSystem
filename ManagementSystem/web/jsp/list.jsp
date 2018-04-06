<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2018/4/5
  Time: 10:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户列表</title>
</head>
<body>
<h2>欢迎你，${sessionScope.adminInfo.name}</h2>
   <h1 align="center">用户列表展示</h1>
   <h5 align="right"><a href="${pageContext.request.contextPath}/jsp/register.jsp">添加用户</a> </h5>
  <c:choose>
      <c:when test="${not empty requestScope.userList}">
        <table align="center" border="2" cellpadding="5" cellspacing="0" width="70%">
            <tr align="center">
                <td>编号</td>
                <td>姓名</td>
                <td>性别</td>
                <td>年龄</td>
                <td>薪水</td>
                <td colspan="2">操作</td>
            </tr>
            <c:forEach var="user" varStatus="status" items="${requestScope.userList}">
                <tr align="center">
                    <td>${status.count}</td>
                    <td>${user.name}</td>
                    <td>${user.gender}</td>
                    <td>${user.age}</td>
                    <td>${user.salary}</td>
                    <c:url var="url" value="/user"/>
                    <td colspan="2"><a href="${url}/deleteById.action?id=${user.id}">删除</a> &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="${url}/update.action?id=${user.id}">修改</a> </td>
                </tr>
            </c:forEach>
        </table>
      </c:when>
      <c:otherwise>
          <h1 align="center">用户列表为空</h1>
      </c:otherwise>
  </c:choose>

</body>
</html>
