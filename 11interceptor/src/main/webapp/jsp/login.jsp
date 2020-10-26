<%--
  Created by IntelliJ IDEA.
  User: hejiayi
  Date: 2020/9/19
  Time: 0:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<!-- 当访问该页面的时候，表示已经登录-->
<%
    request.getSession().setAttribute("user","monkey1024");
%>
</body>
</html>
