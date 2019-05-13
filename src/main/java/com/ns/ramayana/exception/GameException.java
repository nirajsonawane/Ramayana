package com.ns.ramayana.exception;

public class GameException extends RuntimeException {

    public GameException() {
        super();
    }


    public GameException(String message) {
        super(message);
    }


    public GameException(String message, Throwable cause) {
        super(message, cause);
    }
}
