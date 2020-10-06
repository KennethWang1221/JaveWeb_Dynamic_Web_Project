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
<form action="${pageContext.request.contextPath }/map.action" method="post">
    <%--
        设置key值 map['key值']
        设置value值
    --%>
    username:<input type="text" name="map['one'].username"/>
    <br/>
    password:<input type="text" name="map['one'].password"/>
    <br/>
    address:<input type="text" name="map['one'].address"/>

    <br/><br/>

    username:<input type="text" name="map['abcd'].username"/>
    <br/>
    password:<input type="text" name="map['abcd'].password"/>
    <br/>
    address:<input type="text" name="map['abcd'].address"/>

    <input type="submit" value="提交"/>
    <br/>

</form>

</body>
</html>
