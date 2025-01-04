package dao;

import db.myConnection;
import model.Data;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class dataDao {
    public static List<Data> showHiddenFiles(String email) throws SQLException, ClassNotFoundException {
        List<Data> files=new ArrayList<>();
        Connection connection= myConnection.getConnection();
        PreparedStatement ps=connection.prepareStatement("select * from Data where Email=?");
        ps.setString(1,email);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            int id=rs.getInt(1);
            //String email=rs.getString(2);
            String fileName=rs.getString(3);
            String filePath=rs.getString(4);
            files.add(new Data(id,email,fileName,filePath));
        }
        return files;
    }

    public static int hideFile(Data file) throws SQLException, ClassNotFoundException, IOException {
        Connection connection= myConnection.getConnection();
        PreparedStatement ps=connection.prepareStatement("insert into Data (Email,FileName,FilePath,Bin_data) values(?,?,?,?)");

        ps.setString(1,file.getEmail());
        ps.setString(2,file.getFileName());
        ps.setString(3,file.getFilePath());
        File f=new File(file.getFilePath());
        FileReader fr=new FileReader(f);
        ps.setCharacterStream(4,fr,f.length());

        int ans=ps.executeUpdate(); //if ans is 1-> successfully stored
        fr.close();
        f.delete();
        return ans;
    }

    public static void unhideFile(int id) throws SQLException, ClassNotFoundException, IOException {
        Connection connection= myConnection.getConnection();
        PreparedStatement ps=connection.prepareStatement("select * from Data where id=?");
        ps.setInt(1,id);
        ResultSet rs=ps.executeQuery();
        rs.next();
        String path=rs.getString(4);
        Clob c=rs.getClob(5);
        Reader r=c.getCharacterStream();
        FileWriter fw=new FileWriter(path);
        int i ;
        while((i=r.read())!=-1){
            fw.write((char)i);
        }
        fw.close();

        ps=connection.prepareStatement("delete from Data where id=?");
        ps.setInt(1,id);
        ps.executeUpdate();
        System.out.println("Successfully unhidden");
    }
}
