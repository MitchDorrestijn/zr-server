package org.han.ica.oose.boterbloem.utils.exceptions;

/**
 * This exception is thrown when a user is not found
 */
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
