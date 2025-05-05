package com.gti.insurance_configuration.utils.constants;

public final class ErrorConstants {

    private ErrorConstants(){}
    public static final String INTERNAL_SERVER_ERR = "Internal Server Error";
    public static final String NOT_FOUND_ERR = "Record not found";
    public static final String NIVEAU_VALIDATION_INVALID_MSG = "NiveauValidation must be either V1 or V2. Invalid value received: ";
    public static final String NIVEAU_VALIDATION_INVALID_ERR = "Unsupported validation level";
    public static final String CLIENT_CATEGORY_INVALID_MSG = "Unsupported profileClient. Invalid value received: ";
    public static final String CLIENT_CATEGORY_INVALID_ERR = "Unsupported client profile category";
    public static final String INSURANCE_CONFLICT_ERR = "Config conflict error";
    public static final String INSURANCE_CONFLICT_MSG = "Config already exist for: ";
    public static final String FREQUENCE_GENERATION_TYPE_INVALID_ERR = "Unsupported frequence generation type";
    public static final String FREQUENCE_GENERATION_TYPE_INVALID_MSG = "FrequenceGenerationType must be either QUOTIDIENNE or MENSUELLE. Invalid value received: ";
    public static final String COMPOSITE_CONFIG_NOT_FOUND_MSG = "No composite configurations found with ID: ";
    public static final String DELAY_CONFIG_NOT_FOUND_MSG = "No delay configurations found with ID: ";
    public static final String JOKER_INSURANCE_CONFIG_NOT_FOUND_MSG = "No joker insurance configurations found with ID: ";
    public static final String PATH_CONFIG_NOT_FOUND_MSG = "No path configurations found with ID: ";
    public static final String THRESHOLD_CONFIG_NOT_FOUND_MSG = "No threshold configurations found with ID: ";

}
