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
<form action="${pageContext.request.contextPath }/list.action" method="post">
    <%-- list[0]:表示list集合第一个user对象 --%>
    username:<input type="text" name="list[0].username"/><%--传值逻辑讲解 见 b站p31 15-封装表达式到list集合 --%>
    <br/>
    password:<input type="text" name="list[0].password"/>
    <br/>
    address:<input type="text" name="list[0].address"/>
    <br/>
    <%--bname:<input type="text" name="list[0].bname">--%>
    <br/>
    <input type="submit" name="提交"/>

    <br/><br/>


    username:<input type="text" name="list[1].username"/>
    <br/>
    password:<input type="text" name="list[1].password"/>
    <br/>
    address:<input type="text" name="list[1].address"/>
    <br/>
    <%--bname:<input type="text" name="list[1].bname">--%>
    <br/>
    <input type="submit" name="提交"/>

</form>


</body>
</html>
