package org.stc.controller.errors;

public class ForbiddenException extends RuntimeException {

    public ForbiddenException(String msg) {
        super(msg);
    }

    @Override
    public synchronized Throwable fillInStackTrace() { //this method is used to suppress stacktrace
        return this;
    }
}
