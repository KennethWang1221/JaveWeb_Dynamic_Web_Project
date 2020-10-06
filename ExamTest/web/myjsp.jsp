<%--
  Created by IntelliJ IDEA.
  User: wangxiang
  Date: 2018/1/14
  Time: 下午9:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<from action="ELTest" method="post">
    用户名:<%=request.getAttribute("username") %>
    密码:<%=request.getAttribute("password")%>
    <hr/>

    使用EL表达式：<br/>
    用户名:${username}<br/>
    密码:${password}<br/>



</from>

</body>
</html>
