<%--
  Created by IntelliJ IDEA.
  User: wangxiang
  Date: 2018/1/14
  Time: 下午9:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--<jsp:forword page="welcome.jsp">--%>
执行下边的forward
<jsp:forward page="welcome.jsp"/>
    不再执行下边的代码。
<h1>会执行吗？很明显不会！！！</h1>

</body>
</html>
