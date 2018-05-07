package org.han.ica.oose.boterbloem.util.exceptions;



import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ZorginstellingNotFoundException extends RuntimeException {

    public ZorginstellingNotFoundException(int id) {
        super("could not find user '" + String.valueOf(id) + "'.");
    }
}
