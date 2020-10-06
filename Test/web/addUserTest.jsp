<%@ page import="user.vo.UserVo" %>
<%@ page import="UserDao.UserDao" %><%--
  Created by IntelliJ IDEA.
  User: wangxiang
  Date: 2017/12/2
  Time: 上午8:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    //真正接收数据的jsp
    request.setCharacterEncoding("utf-8");
    String name=request.getParameter("name");
    String password=request.getParameter("password");
    String password2=request.getParameter("password2");
    String age=request.getParameter("age");

    if(!password.equals(password2)){
%>
<script>
    alert("两次密码不一致");
    window.location.href="addUserFormTest.jsp";
</script>
<%
        return;
    }

    UserVo user=new UserVo();
    user.setName(name);
    user.setPassword(password);
    user.setAge(age);

    int res=new UserDao().addUserByObj(user);

    if(res!=0){
%>
<script>
    alert("用户添加成功");
    window.location.href="addUserFormTest.jsp";
</script>
<%
    }else{
%>
<script>
    alert("用户添加失败");
    window.location.href="addUserFormTest.jsp";
</script>
<%
    }
%>

</body>
</html>
