package com.gti.insurance_configuration.services.impl;

import com.gti.insurance_configuration.client.ClientCategoryApiClient;
import com.gti.insurance_configuration.models.client.ClientCategoryResponse;
import com.gti.insurance_configuration.services.ClientCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
@RequiredArgsConstructor
public class ClientCategoryServiceImpl implements ClientCategoryService {

    private final ClientCategoryApiClient apiClient;
    @Override
    public List<String> getAllClientCategoryLabels() {
        return apiClient.getAllClientCategories()
                .stream()
                .map(ClientCategoryResponse::getLabel)
                .toList();
    }

    @Override
    public boolean isValidClientCategory(String categoryLabel) {
        return getAllClientCategoryLabels().contains(categoryLabel);
    }
}
