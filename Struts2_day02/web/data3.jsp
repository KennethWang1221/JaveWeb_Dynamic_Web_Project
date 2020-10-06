<%--
  Created by IntelliJ IDEA.
  User: wangxiang
  Date: 2019-03-03
  Time: 21:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/data3.action" method="post">
    username:<input type="text" name="user.username"/><%--传值逻辑讲解 见 b站p29 12-表达式封装 4分钟--%>
    <br/>
    password:<input type="text" name="user.password"/>
    <br/>
    address:<input type="text" name="user.address"/>
    <br/>
    bname:<input type="text" name="book.bname">
    <br/>
    <input type="submit" name="提交"/>

</form>


</body>
</html>
