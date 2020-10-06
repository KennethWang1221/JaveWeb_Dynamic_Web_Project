<%@ page import="java.sql.*" %><%--
  Created by IntelliJ IDEA.
  User: wangxiang
  Date: 2019-02-27
  Time: 20:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>网页输出数据库中的信息</title>
</head>
<body>
    <h2>从数据库中读取所有用户，并且列表显示</h2>
    <%!
        Connection conn=null;
        Statement stmt=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        String DBDriver="com.mysql.jdbc.Driver";
        String dburl="jdbc:mysql://127.0.0.1:3306/logintest";
        String usn="root";
        String psd="root";

    %>

    <%
        Class.forName(DBDriver);
        conn= DriverManager.getConnection(dburl,usn,psd);
        stmt=conn.createStatement();

        String sql="select * from users";
        rs=stmt.executeQuery(sql);
    %>
    <table width ="600" border="1" align="center" style="color:blue">
        <tr>
            <th>编号</th>
            <th>姓名</th>
            <th>密码</th>
            <th>年龄</th>
        </tr>

        <%
            while(rs.next()){
        %>
        <tr>
            <td><%=rs.getString(1)%></td>
            <td><%=rs.getString(2)%></td>
            <td><%=rs.getString(3)%></td>
            <td><%=rs.getString(4)%></td>
        </tr>
        <%
            }
        %>
    </table>>



</body>
</html>
