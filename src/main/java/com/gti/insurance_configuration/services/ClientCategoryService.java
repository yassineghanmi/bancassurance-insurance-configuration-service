package com.gti.insurance_configuration.services;

import java.util.List;

public interface ClientCategoryService {
    List<String> getAllClientCategoryLabels();
    boolean isValidClientCategory(String categoryCode);
}