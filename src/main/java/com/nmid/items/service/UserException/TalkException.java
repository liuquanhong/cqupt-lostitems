package com.nmid.items.service.UserException;

public class TalkException extends RuntimeException {


    public TalkException() {
        super();
    }

    public TalkException(String message) {
        super(message);
    }

    public TalkException(String message, Throwable cause) {
        super(message, cause);
    }

    protected TalkException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
