package com.gti.insurance_configuration.utils.exceptions;

import com.gti.insurance_configuration.utils.constants.ErrorConstants;

public class UnsupportedValidationLevelException extends RuntimeException{
    public UnsupportedValidationLevelException(String msg){
        super(ErrorConstants.NIVEAU_VALIDATION_INVALID_MSG + msg);
    }
}
