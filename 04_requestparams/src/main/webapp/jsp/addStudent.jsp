<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <form action="/student/add2.do" method="post">
        姓名：<input type="text" name="username">
        <br>
        年龄：<input type="text" name="age">

        <br>
        <!--通过对象属性.属性的方式 -->
        学校名称：<input type="text" name="school.schoolName">
        <br>
        学校地址：<input type="text" name="school.address">
        <input type="submit" value="提交">
    </form>
</body>
</html>
