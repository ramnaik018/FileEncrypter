import views.welcome;

import java.io.IOException;
import java.sql.SQLException;


public class Main {
    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
        System.out.println("hello fucker");
        welcome wc=new welcome();
        wc.welcomeScreen();
    }
}
