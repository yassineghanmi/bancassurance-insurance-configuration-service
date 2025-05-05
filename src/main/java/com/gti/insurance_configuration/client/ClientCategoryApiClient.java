package com.gti.insurance_configuration.client;

import com.gti.insurance_configuration.client.config.FeignConfig;
import com.gti.insurance_configuration.models.client.ClientCategoryResponse;
import com.gti.insurance_configuration.utils.constants.ClientConstants;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(
        name = ClientConstants.CLIENT_CATEGORY_API_NAME,
        url = ClientConstants.CLIENT_DEFAULT_URL,
        configuration = FeignConfig.class
)
public interface ClientCategoryApiClient {

    @GetMapping("/api/categ_clients")
    List<ClientCategoryResponse> getAllClientCategories();
}