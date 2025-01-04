package service;

import java.util.Random;

public class genOTPService {
    public static String getOTP(){
        Random rdm=new Random();
        return String.format("%04d",rdm.nextInt(10000));
    }
}
