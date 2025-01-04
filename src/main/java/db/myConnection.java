package db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class myConnection {
    public static Connection connection;
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        //First load driver class
        Class.forName("com.mysql.cj.jdbc.Driver");
        //then using DriverManager class , establish a connection by passing url,username,pass
        String url="jdbc:mysql://localhost:3306/fileEncrypter";
        connection=DriverManager.getConnection(url,"root","Kittu@8688");
        System.out.println("connection has been established at : "+connection);
        return connection;
    }

    public static void closeConnection(){
        if(connection!=null){
            try{
                connection.close();
                System.out.println("connection has been closed!");
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }
    }
}
