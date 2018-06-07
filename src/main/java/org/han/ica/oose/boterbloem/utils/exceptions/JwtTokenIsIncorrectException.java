package org.han.ica.oose.boterbloem.utils.exceptions;

/**
 * This exception is thrown when the JWT is not correct
 */
public class JwtTokenIsIncorrectException extends RuntimeException {
    public JwtTokenIsIncorrectException(String message) {
        super(message);
    }
}
