package org.webflux_reference.functional_endpoints.excpetions;

public class InvalidInputException extends RuntimeException {

    public InvalidInputException(String message) {
        super(message);
    }

}
