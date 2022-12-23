package org.api.customExceptions;

public class StatusCodeMisMatchExceptions extends Exception{
    public StatusCodeMisMatchExceptions(String errorMessage) {
        super(errorMessage);
    }
}
