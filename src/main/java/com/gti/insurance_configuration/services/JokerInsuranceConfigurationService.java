package com.gti.insurance_configuration.services;

import com.gti.insurance_configuration.models.requests.JokerInsuranceConfigCreateRequest;
import com.gti.insurance_configuration.models.requests.JokerInsuranceConfigUpdateRequest;
import com.gti.insurance_configuration.models.responses.JokerInsuranceConfigurationResponse;
import com.gti.insurance_configuration.models.responses.ThresholdsConfigurationResponse;
import com.gti.insurance_configuration.repositories.entities.JokerInsuranceConfiguration;
import org.springframework.data.domain.Page;

import java.util.List;

public interface JokerInsuranceConfigurationService {
    JokerInsuranceConfigurationResponse get(Long id);
    Page<JokerInsuranceConfigurationResponse> findAllWithFilters(String insurer, String insurance, String clientProfile, int page, int size);
    JokerInsuranceConfigurationResponse create(JokerInsuranceConfigCreateRequest request);
    JokerInsuranceConfigurationResponse update(Long id , JokerInsuranceConfigUpdateRequest request);
    void delete(Long id);
}
