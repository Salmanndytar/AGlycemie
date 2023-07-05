package com.ndytar.aglycemie.exception;

public enum ErrorCodes {
    ALIMENT_NOT_FUOND(404),
    ALIMENT_NOT_VALID(400),
    UTILISATEURS_NOT_FUOND(404),
    UTILISATEURS_NOT_VALID(400),
    CATEGORIE_NOT_FUOND(404),
    CATEGORIE_NOT_VALID(400),

    ROLE_NOT_FUOND(404),

    ROLE_NOT_VALID(400),

    BAD_CREDENTIALS(400),
   OPERATION_INVALID(401),
    EMPTY_RESULT(406),
    NOT_ACCEPTABLE(406),
    OBJECT_UTILISE_AUTRE(407),
    LIMITE_ATTEND_CONN_SMTP(1000),
    SMTP_OPERATION_NOT_SUCCESS(1001),
    CONNECTION_PROBLEM(1002),
    EXPIRED_JWT(403);


    private  int code;
    ErrorCodes(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
