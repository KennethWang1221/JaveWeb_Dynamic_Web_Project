<%--
  Created by IntelliJ IDEA.
  User: wangxiang
  Date: 2018/1/14
  Time: 下午3:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--<%
    HttpServletRequest req=(HttpServletRequest) pageContext.getRequest();

    pageContext.setAttribute("str","javava",pageContext.PAGE_SCOPE);
    req.setAttribute("str","javawebbbb");

    String str1=(String)pageContext.getAttribute("str",pageContext.PAGE_SCOPE);
    String str2=(String)pageContext.getAttribute("str",pageContext.REQUEST_SCOPE);
%>
    <h1><%="page范围的值:"+str1 %></h1>
    <h1><%="request范围的值："+str2 %></h1>--%>





<%
    HttpServletRequest req=(HttpServletRequest)pageContext.getRequest();

    pageContext.setAttribute("str","qqq",pageContext.PAGE_SCOPE);
    req.setAttribute("str","aaa");

    String str1=(String)pageContext.getAttribute("str",pageContext.PAGE_SCOPE);
    String str2=(String)pageContext.getAttribute("str",pageContext.REQUEST_SCOPE);
%>

<h1><%=str1 %></h1>
<h1><%=str2 %></h1>







</body>
</html>
