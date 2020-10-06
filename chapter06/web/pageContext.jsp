<%--
  Created by IntelliJ IDEA.
  User: wangxiang
  Date: 2017/11/9
  Time: 下午11:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
        <%
            //获取request对象
            HttpServletRequest req=(HttpServletRequest) pageContext.getRequest();
            //设置page范围内属性
            String msg1="Java";
            pageContext.setAttribute("str",msg1,pageContext.PAGE_SCOPE);
            //设置request范围内属性
            String msg2="Java Web";
            req.setAttribute("str",msg2);
            //获得的page范围属性
            String str1=(String) pageContext.getAttribute("str",pageContext.PAGE_SCOPE);
            //获得request范围对象
            String str2=(String) pageContext.getAttribute("str",pageContext.REQUEST_SCOPE);


        %>
        <%="page 范围"+str1 %><br/>
        <%="request 范围 "+str2 %><br/>

</body>
</html>
