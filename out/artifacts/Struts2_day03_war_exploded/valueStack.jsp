<%--
  Created by IntelliJ IDEA.
  User: wangxiang
  Date: 2019-03-04
  Time: 20:51
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%-- 使用struts2标签查看值栈结构 --%>
    <s:debug >这是debug标签</s:debug>
    <br/>
    <%-- 1 获取字符串值 --%>
    <%--<s:property value="username"/>--%>

    <%--2 获取值栈对象的值--%>
    <s:property value="user.username"/>
    <s:property value="user.password"/>
    <s:property value="user.address"/>

    <%-- 3 获取值栈list集合数据--%>
    <%--第一种方式实现 这种有缺陷 就是 里边的值是固定的，知道有三个对象，四个对象 可以用这种方法--%>
    <br/>
    获取list中的值
    获取list
    <br/>
    <s:property value="list[0].username"/>
    <s:property value="list[0].password"/>
    <s:property value="list[0].address"/>

    <s:property value="list[1].username"/>
    <s:property value="list[1].password"/>
    <s:property value="list[1].address"/>

    <br/>

    获取list的值第二种方式
    <br/>
    <%--
        使用 struts2 标签 类似 jstl 的foreach 标签
        <c:foreach items="" var="user">
            ${user.username}
        </foreach>
        <s:iterator> 遍历值栈的list集合
    --%>
    <s:iterator value="list">
        <%-- 遍历list得到list里面每个user对象 --%>
        <s:property value="username"/>
        <s:property value="password"/>
        <s:property value="address"/>
        <br/>
    </s:iterator>

    <br/>
    获取list的值第三种方式
    <br/>
    <%--
        遍历值栈 list 集合 ，得到每个user对象
        有一种特殊的机制：把每次遍历出来的user对象放到context里面
        获取context 里面数据的特点，写ognl 表达式
        使用特殊符号 #
    --%>
    <s:iterator value="list" var="user">
        <s:property value="#user.username"/>
        <s:property value="#user.password"/>
        <s:property value="#user.address"/>
        <br/>

    </s:iterator>


    <br/>
    <%-- 使用foreach标签 + el 表达式获取值栈 list 集合数据 --%>
    <c:forEach items="${list}" var="user">
        ${user.username}
        ${user.password}
        ${user.address}

        <br/>
    </c:forEach>

<type s>

    <%--获取set方法设置的值，直接根据名称获取值--%>
    <%--<s:property value="username"/>--%>

    <br/>
    <%--获取push方法设置的值，--%>
    <%--<s:property value="[0].top"/>--%>








</body>
</html>
