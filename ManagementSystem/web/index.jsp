<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title></title>
  </head>
  <body>
   <form action="${pageContext.request.contextPath}/admin/login.action" method="post">
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
                   密码
               </td>
               <td>
                   <input type="password" name="pwd">
               </td>
           </tr>
           <tr>
               <td colspan="2" align="center">
                   <input type="submit" value="添加用户">
               </td>
           </tr>
   </form>
  </body>
</html>