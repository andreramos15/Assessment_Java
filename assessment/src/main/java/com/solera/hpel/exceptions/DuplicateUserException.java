package main.java.com.solera.hpel.exceptions;

public class DuplicateUserException extends Exception {

    public DuplicateUserException(String message) {
        super(message);
    }
}