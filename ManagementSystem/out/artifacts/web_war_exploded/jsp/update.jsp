<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2018/4/5
  Time: 9:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>添加用户页面</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/user/saveUpdate.action" method="post">
    <input type="hidden" name="id" value="${userInfo.id}">
    <table align="center" border="2" width="50%" cellspacing="0" cellpadding="5">
        <tr>
            <td>
                用户名
            </td>
            <td>
                <input type="text" name="name" value="${userInfo.name}">
            </td>
        </tr>
        <tr>
            <td>
                性别
            </td>
            <td>

                <input type="radio" name="gender" value="男"  value="${userInfo.gender}"
                 <c:choose>
                        <c:when test="${userInfo.gender == '男'}">
                        checked
                </c:when>
                </c:choose>
                >男
                <input type="radio" name="gender" value="女"
                <c:choose>
                <c:when test="${userInfo.gender =='女'}">
                       checked
                </c:when>
                </c:choose>
                >女
            </td>
        </tr>
        <tr>
            <td>
                年龄
            </td>
            <td>
                <input type="text" name="age"  value="${userInfo.age}">
            </td>
        </tr>
        <tr>
            <td>
                薪水
            </td>
            <td>
                <input type="text" name="salary" value="${userInfo.salary}">
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="修改">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
