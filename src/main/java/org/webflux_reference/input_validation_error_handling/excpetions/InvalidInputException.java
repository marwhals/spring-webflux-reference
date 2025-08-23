package org.webflux_reference.input_validation_error_handling.excpetions;

public class InvalidInputException extends RuntimeException {

    public InvalidInputException(String message) {
        super(message);
    }

}
