package views;

import dao.dataDao;
import model.Data;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import static dao.dataDao.showHiddenFiles;

public class userView {
    private final String email;

    public userView(String email) {
        this.email = email;
    }

    public void home() throws SQLException, ClassNotFoundException, IOException {
        do{
            System.out.println("Welcome "+this.email);
            System.out.println("Press 1 to show hidden files");
            System.out.println("Press 2 to hide new file");
            System.out.println("Press 3 to un hide files");
            System.out.println("Press 0 to exit");

            Scanner sc=new Scanner(System.in);
            int choice=sc.nextInt();
            sc.nextLine();// consume leftover by sc.nextInt() in above line.

            switch(choice){
                case 1-> {
                    List<Data> files=showHiddenFiles(this.email);
                    System.out.println("ID - File_Name ");
                    for(Data d:files){
                        System.out.println(d.getId()+"  "+d.getFileName());
                    }
                }
                case 2-> {
                    System.out.println("Enter the file path:");
                    String path=sc.nextLine();
                    File f=new File(path);
                    Data file=new Data(0,this.email,f.getName(),path);

                    dataDao.hideFile(file);
                }
                case 3-> {
                    List<Data> files=showHiddenFiles(this.email);
                    System.out.println("ID - File_Name ");
                    for(Data d:files) {
                        System.out.println(d.getId() + "  " + d.getFileName());
                    }
                    System.out.println("enter the id of file to un hide it:");
                    int id=Integer.parseInt(sc.nextLine());
                    boolean isValidId=false;
                    for(Data d:files) {
                        if(d.getId()==id){
                            isValidId=true;
                            break;
                        }
                    }
                    if(isValidId){
                        dataDao.unhideFile(id);
                    }else{
                        System.out.println("Wrong id");
                    }
                }
                case 0-> System.exit(0);
            }
        }while(true);
    }
}
