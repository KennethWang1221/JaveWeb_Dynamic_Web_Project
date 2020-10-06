package UserDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetConn {
    Connection conn=null;
    String DBDriver="com.mysql.jdbc.Driver";
    String dburl="jdbc:mysql://127.0.0.1:3306/logintest";
    String usn="root";
    String psd="root";

    public Connection getConn(){
        try {
            Class.forName(DBDriver);
            conn= DriverManager.getConnection(dburl,usn,psd);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
