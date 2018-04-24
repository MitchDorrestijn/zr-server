package org.han.ica.oose.boterbloem;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoderGenerator {
    public static void main(String[] args) {
        PasswordEncoderGenerator g = new PasswordEncoderGenerator();
        String test = g.getNewPassword();
        System.out.println(test);
        }

    /**
     * function creates a new hashed password
     * @return new hashed password to be stored in database
     */
    public String getNewPassword(){
        String password = "123456"; // dit wordt het wachtwoord wat de user aangeeft bij het registreren
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);
        return hashedPassword;
    }
}
