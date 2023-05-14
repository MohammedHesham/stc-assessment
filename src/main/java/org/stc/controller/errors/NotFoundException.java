package org.stc.controller.errors;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String msg) {
        super(msg);
    }

    @Override
    public synchronized Throwable fillInStackTrace() { //this method is used to suppress stacktrace
        return this;
    }
}
