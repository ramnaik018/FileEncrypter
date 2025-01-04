package views;

import model.User;
import service.SendOTPService;
import service.genOTPService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.Scanner;

import static dao.userDao.isFound;
import static dao.userDao.saveUser;
import static service.genOTPService.getOTP;
import static java.lang.Integer.parseInt;

public class welcome {
    public void welcomeScreen() throws IOException, SQLException, ClassNotFoundException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Welcome to the app..!");
        System.out.println("Please press 1 to login");
        System.out.println("Please press 2 to signUp");
        System.out.println("Please press 0 to exit");
        int choice=parseInt(br.readLine());

        switch(choice){
            case 1->login();
            case 2->signUp();
            case 0-> System.exit(0);
        }
    }

    public void login(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Please enter the email to login:");
        String email=sc.nextLine();
        try{
            if(isFound(email)==true){
                String genOtp= genOTPService.getOTP();
                SendOTPService.sendOTP(email,genOtp);
                System.out.println("Enter the OTP : ");
                String userOtp=sc.nextLine();
                if(genOtp.equals(userOtp)){
                    new userView(email);
                }else{
                    System.out.println("Wrong OTP");
                }
            }else{
                System.out.println("User NOT found!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void signUp() throws SQLException, ClassNotFoundException {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Name : ");
        String name=sc.nextLine();
        System.out.println("Enter Email : ");
        String email=sc.nextLine();

        String genOtp= genOTPService.getOTP();
        SendOTPService.sendOTP(email,genOtp);
        System.out.println("Enter the OTP : ");
        String userOtp=sc.nextLine();
        if(genOtp.equals(userOtp)){
            System.out.println("Authentication successful ! Right away to sign you up.");
            User newUser=new User(name,email);
            int res=saveUser(newUser);
            if(res==1){
                System.out.println("user already exists");
            }else{
                System.out.println("user saved");
            }
        }else{
            System.out.println("Wrong OTP");
        }

    }
}
