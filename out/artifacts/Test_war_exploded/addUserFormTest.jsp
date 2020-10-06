<%--
  Created by IntelliJ IDEA.
  User: wangxiang
  Date: 2017/12/2
  Time: 上午8:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2 align="center">请输入信息</h2>
    <form action="addUserTest.jsp" method="post">
        <table width="600" border="1" align="center" style="color: palevioletred">
            <tr>
                <td>用户名</td>
                <td><input type="text" name="name"></td>
            </tr>

            <tr>
                <td>密码</td>
                <td><input type="password" name="password"></td>
            </tr>

            <tr>
                <td>重复密码</td>
                <td><input type="password" name="password2"></td>
            </tr>

            <tr>
                <td>年龄</td>
                <td><input type="text" name="age" ></td>
            </tr>

            <tr>
                <td>添加</td>
                <td><input type="submit" value="添加"></td>
            </tr>

        </table>
    </form>

</body>
</html>
