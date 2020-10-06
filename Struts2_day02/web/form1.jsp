<%--
  Created by IntelliJ IDEA.
  User: wangxiang
  Date: 2019-03-03
  Time: 15:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Action获取表单提交数据主要三种方式</title>
    <%--
    本例子与form2DemoAction 搭配 采用第二种方式获取表单提交的数据
    （1）使用 ACtionContext类
    （2）使用servletContext 类
    （3）使用接口注入方式
    --%>
</head>
<body>
<form action="${pageContext.request.contextPath }/form4.action" method="post">
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
