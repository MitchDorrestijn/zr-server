package org.han.ica.oose.boterbloem;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.regex.Pattern;

public class PasswordHashExample {

    public static void main(String[] args) {
        BCryptPasswordEncoder g = new BCryptPasswordEncoder();
        String test = g.encode("test");
        System.out.println(test);
        }

        // maak gebruik van de BCryptPasswordEncoder class

}
