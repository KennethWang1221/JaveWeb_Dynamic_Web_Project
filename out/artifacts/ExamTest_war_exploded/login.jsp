<%--
  Created by IntelliJ IDEA.
  User: wangxiang
  Date: 2018/1/14
  Time: 下午7:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<form action="RequestParamServlet" method="post">
    用户名： <input type="text" name="usn"/>
    密码：   <input type="password" name="psd"/>
    爱好：   <input type="checkbox" name="hobby" value="唱歌"/>唱歌
            <input type="checkbox" name="hobby" value="读书"/>读书
            <input type="checkbox" name="hobby" value="跳舞">跳舞
            <input type="checkbox" name="hobby" value="吃吃吃"/>吃吃吃
    提交：   <input type="submit" value="登陆"/>

</form>
</body>
</html>
