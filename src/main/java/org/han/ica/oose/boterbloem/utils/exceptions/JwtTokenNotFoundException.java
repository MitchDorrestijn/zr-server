package org.han.ica.oose.boterbloem.utils.exceptions;

/**
 * This exception is thrown when a JWT is not found
 */
public class JwtTokenNotFoundException extends RuntimeException {
    public JwtTokenNotFoundException(String message) {
        super(message);
    }
}
