package vn.edu.hcmuaf.fit.webike.services;
import java.util.Random;
public class OTPService {
    public static String generateOTP() {
        Random random = new Random();
        int otp = 100000 + random.nextInt(900000);
        return String.valueOf(otp);
    }
}
