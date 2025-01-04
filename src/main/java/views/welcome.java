package views;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Integer.parseInt;

public class welcome {
    public void welcomeScreen() throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Welcome to the app..!");
        System.out.println("Please press 1 to login");
        System.out.println("Please press 3 to signUp");
        System.out.println("Please press 0 to exit");
        int choice=parseInt(br.readLine());

        switch(choice){
            case 1->login();
            case 2->signUp();
            case 0-> System.exit(0);
        }
    }

    public void login(){
        System.out.println("logged in");
    }

    public void signUp(){
        System.out.println("signed up");
    }
}
