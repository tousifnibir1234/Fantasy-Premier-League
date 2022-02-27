package sample;
import java.sql.*;
public class Adapter {
    String url = "jdbc:postgresql://localhost:5432/postgres";
    String username ="postgres";
    String password = "1234";

    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;

    public void connect (){

        try {
            conn = DriverManager.getConnection(url, username, password);
//            System.out.println("connection is established");
//            stmt= conn.prepareStatement("SELECT * FROM fantasyleague");
//            rs= ((PreparedStatement) stmt).executeQuery();
//            while(rs.next())
//            {
//                System.out.println(rs.getString(1)+rs.getInt(2));
//            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
    public void disconnect()
    {
        try {
            if (stmt != null)
                stmt.close();
            if(rs!= null)
                rs.close();
            if(conn != null)
                conn.close();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }


}
