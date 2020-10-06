<%--
  Created by IntelliJ IDEA.
  User: wangxiang
  Date: 2019-03-04
  Time: 16:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--
        使用ognl+struts2 标签实现计算字符串长度
        value属性值里边写的是 ognl 表达式
    --%>
    <s:property value="'haha'.length()"/>

</body>
</html>
