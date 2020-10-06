<%--
  Created by IntelliJ IDEA.
  User: wangxiang
  Date: 2018/1/13
  Time: 下午11:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    String flash=request.getParameter("shuaxin");

%>

<h1 style="color:red;size:35px">MyJsp.jsp刷新的次数为：<%=flash %></h1>





</body>
</html>
