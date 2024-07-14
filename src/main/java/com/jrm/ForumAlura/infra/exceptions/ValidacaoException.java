package com.jrm.ForumAlura.infra.exceptions;

public class ValidacaoException extends RuntimeException{
    public ValidacaoException(String message){
        super(
                message
        );
    }
}
