<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2018/4/5
  Time: 9:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加用户页面</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/user/add.action" method="post">
    <table align="center" border="2" width="50%" cellspacing="0" cellpadding="5">
        <tr>
            <td>
                用户名
            </td>
            <td>
                <input type="text" name="name">
            </td>
        </tr>
        <tr>
            <td>
                性别
            </td>
            <td>
                <input type="radio" name="gender" value="男">男
                <input type="radio" name="gender" value="女">女
            </td>
        </tr>
        <tr>
            <td>
                年龄
            </td>
            <td>
                <input type="text" name="age">
            </td>
        </tr>
        <tr>
            <td>
                薪水
            </td>
            <td>
                <input type="text" name="salary">
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="添加用户">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
