package com.gti.insurance_configuration.services;

import com.gti.insurance_configuration.models.requests.ThresholdsConfigUpdateRequest;
import com.gti.insurance_configuration.models.responses.PathConfigurationResponse;
import com.gti.insurance_configuration.models.responses.ThresholdsConfigurationResponse;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ThresholdsConfigurationService {

    Page<ThresholdsConfigurationResponse> findAllWithFilters(String insurance, int page, int size);
    ThresholdsConfigurationResponse get(Long id);
    ThresholdsConfigurationResponse update(Long id, ThresholdsConfigUpdateRequest request);
}
