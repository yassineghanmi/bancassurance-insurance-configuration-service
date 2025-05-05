package com.gti.insurance_configuration.utils.validator;

import com.gti.insurance_configuration.repositories.CompositeConfigRepository;
import com.gti.insurance_configuration.utils.constants.ErrorConstants;
import com.gti.insurance_configuration.utils.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ThresholdsConfigurationValidator {
    private final CompositeConfigRepository repository;

    public void validateExists(Long id) {
        if (!repository.existsById(id)) {
            throw new NotFoundException(
                    ErrorConstants.THRESHOLD_CONFIG_NOT_FOUND_MSG + id
            );
        }
    }
}
