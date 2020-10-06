<%@ page import="user.vo.USerVo" %>
<%@ page import="UserDao.UserDao" %><%--
  Created by IntelliJ IDEA.
  User: wangxiang
  Date: 2017/12/2
  Time: 上午12:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        request.setCharacterEncoding("utf-8");
        //真正接收表单数据信息，组织数据单位（封装为VO对象），调用dao对象，完成数据库的访问
        String name=request.getParameter("name");
        String password=request.getParameter("password");
        String password2=request.getParameter("password2");
        String age=request.getParameter("age");

        //数据密码校验
        if(!password.equals(password2)){
    %>
    <script>
        alert("两次密码错误");
        window.location.href="addUSerFormTest.jsp";
    </script>
    <%
        return;
        }


        //封装UserVo对象
        USerVo user=new USerVo();
        user.setName(name);
        user.setPassword(password);
        user.setAge(age);

        int res=new UserDao().addUSerByObj(user);
        if(res!=0){
    %>
    <script>
        alert("用户添加成功");
        window.location.href="addUserFormTest";
    </script>
    <%
        }else{
    %>
    <script>
        alert("用户添加失败");
        window.location.href="addUserFormTest";
    </script>
    <%
        {

    }%>
</body>
</html>
