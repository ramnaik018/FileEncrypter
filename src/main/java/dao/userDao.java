package dao;

import db.myConnection;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class userDao {
    public static boolean isFound(String email) throws SQLException, ClassNotFoundException {
        //first make a connection to sql
        Connection connection= myConnection.getConnection();

        PreparedStatement ps=connection.prepareStatement("select * from User where Email = ?");
        ps.setString(1,email);
        ResultSet rs=ps.executeQuery();
        if(rs!=null) {
            return true;
        }
        return false;
    }

    public static int saveUser(User usr) throws SQLException, ClassNotFoundException {
        Connection connection=myConnection.getConnection();
        String qr="insert into User(Name,Email) " +
                  "values (?,?)";
        PreparedStatement ps=connection.prepareStatement(qr);
        ps.setString(1,usr.getName());
        ps.setString(2,usr.getEmail());
        return ps.executeUpdate();//return number of rows affected.
    }
}
