package com.ll.exam.app351.app.order.exception;

public class ProductOptionNotFoundException extends RuntimeException {
    public ProductOptionNotFoundException() {
    }

    public ProductOptionNotFoundException(String message) {
        super(message);
    }

    public ProductOptionNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProductOptionNotFoundException(Throwable cause) {
        super(cause);
    }

    public ProductOptionNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
