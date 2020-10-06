package UserDao;

import user.vo.UserVo;

import java.sql.*;

public class UserDao {
    Connection conn=null;
    Statement stmt=null;
    ResultSet rs=null;
    PreparedStatement pstmt=null;

    public int addUserByObj(UserVo user){
        int res=0;
        conn=new GetConn().getConn();
        String sql="insert into users(name,password,age) " +
                "values(?,?,?)";
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,user.getName());
            pstmt.setString(2,user.getPassword());
            pstmt.setString(3,user.getAge());

            res=pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.close();
        }

        return res;
    }














    public void close(){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(stmt!=null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(pstmt!=null){
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
