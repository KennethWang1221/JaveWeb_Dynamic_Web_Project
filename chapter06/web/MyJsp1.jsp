<%--
  Created by IntelliJ IDEA.
  User: wangxiang
  Date: 2017/11/8
  Time: 上午12:18
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
        int a=0,b=0,c=0;

        public int getMax(int a,int b){
            if (a>b){
                c=a;
            }else{
                c=b;
            }
                return c;
        }
    %>
    <%
    //num++
    out.println("最大的数为："+this.getMax(1,11));
    int  sx=num++;
    %>
    <%-- <h1 style="color :red;size:35px"> 本网页的刷新数为<%=num %></h1> --%>
    <%-- <a style="color:blue;size:40px" href="MyJsp2.jsp?sx=<%=num %>">跳转到MyJsp2.jsp</a>--%>
    <h1 style="color :red;size:35px"> 本网页的刷新数为<%=sx %></h1>
    <a style="color:blue;size:40px" href="MyJsp2.jsp?shuaxin=<%=sx %>">跳转到MyJsp2.jsp</a>
</body>
</html>
