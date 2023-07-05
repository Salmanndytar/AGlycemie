package com.ndytar.aglycemie.exception;

import lombok.Getter;

public class SMTPSendFailedExceptions extends  Exception {
    @Getter
    private ErrorCodes errorCodes;
    public SMTPSendFailedExceptions(String message){
        super(message);
    }

    public SMTPSendFailedExceptions(String message, ErrorCodes errorCodes){
        super(message);
        this.errorCodes=errorCodes;
    }
}
