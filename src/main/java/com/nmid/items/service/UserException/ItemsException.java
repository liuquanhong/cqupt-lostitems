package com.nmid.items.service.UserException;

public class ItemsException extends RuntimeException {

    public ItemsException() {
        super();
    }

    public ItemsException(String message) {
        super(message);
    }

    public ItemsException(String message, Throwable cause) {
        super(message, cause);
    }

    public ItemsException(Throwable cause) {
        super(cause);
    }

    protected ItemsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }


}
