<%--
  Created by IntelliJ IDEA.
  User: wangxiang
  Date: 2017/11/8
  Time: 上午12:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" import="java.util.*"  language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        String flash =request.getParameter("shuaxin");
    %>
    <h1 style="color :red;size:45px">MyJsp2.jsp网页刷新数为<%=flash %></h1>

</body>
</html>
