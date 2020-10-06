
<%--
  Created by IntelliJ IDEA.
  User: wangxiang
  Date: 2018/1/13
  Time: 下午10:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%!
    int num=0;
    int a,b,c;
    public int getMax(int a,int b){
        if(a>b){
            c=a;
        }else{
            c=b;
        }
        return c;
    }
%>
<%
    int sx = num++;
    out.println("最大的数为："+this.getMax(12,99));
%>
<h1 style="color:red;size:35px">本网页刷新的数为：<%=sx %> </h1>
<a style="color:red;size:35px" href="MyJsp4.jsp?shuaxin=<%=sx %>">跳转到MyJsp4.jsp</a>






</body>
</html>
