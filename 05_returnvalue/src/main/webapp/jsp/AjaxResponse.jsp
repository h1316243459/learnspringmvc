<%--
  Created by IntelliJ IDEA.
  User: hejiayi
  Date: 2020/9/14
  Time: 1:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="/js/jquery-3.3.1.js"></script><!-- 这个包我没到进来-->
</head>
<body>
        <button id="ajaxRequest">提交</button>
</body>
<script>
    $(function(){
        $("#ajaxRequest").click(function () {
            $.ajax({
                method:"post",
                url:"/returnString",
                success:function(result){
                    console.log(result);
                }
            })
        })
    })

</script>
</html>
