package vn.edu.hcmuaf.fit.webike.services;

import com.warrenstrange.googleauth.GoogleAuthenticator;
import vn.edu.hcmuaf.fit.webike.models.User;

public class TwoFAService {
    public static boolean verifyCode(User user, String code) {
        String secret = user.getOtpSecret();
        if (secret == null || secret.isEmpty()) return false;
        long codeLong;
        try {
            codeLong = Long.parseLong(code);
        } catch (NumberFormatException e) {
            return false;
        }
        GoogleAuthenticator gAuth = new GoogleAuthenticator();
        return gAuth.authorize(secret, (int) codeLong);
    }
}
