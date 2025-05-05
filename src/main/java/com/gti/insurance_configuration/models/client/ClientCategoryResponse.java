package com.gti.insurance_configuration.models.client;

import com.fasterxml.jackson.annotation.JsonProperty;
public class ClientCategoryResponse {
    @JsonProperty("COD_CATEG")
    private String code;

    @JsonProperty("LIB_CATEG")
    private String label;

    // Getters and Setters
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "ClientCategoryResponse{" +
                "code='" + code + '\'' +
                ", label='" + label + '\'' +
                '}';
    }
}