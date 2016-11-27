package com.training.lab.exception;

public class FlowersException extends Exception {
    public FlowersException() {
        super();
    }

    public FlowersException(String s) {
        super(s);
    }

    public FlowersException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public FlowersException(Throwable throwable) {
        super(throwable);
    }
}
