<%--
  Created by IntelliJ IDEA.
  User: wangxiang
  Date: 2019-03-03
  Time: 17:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/data1.action" method="post">
    username:<input type="text" name="username"/>
    <br/>
    password:<input type="text" name="password"/>
    <br/>
    address:<input type="text" name="address"/>
    <br/>
    <input type="submit" name="提交"/>

</form>

</body>
</html>
