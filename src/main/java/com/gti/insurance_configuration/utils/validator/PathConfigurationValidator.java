package com.gti.insurance_configuration.utils.validator;

import com.gti.insurance_configuration.models.requests.PathConfigurationCreateRequest;
import com.gti.insurance_configuration.models.requests.PathConfigurationUpdateRequest;
import com.gti.insurance_configuration.repositories.PathConfigurationRepository;
import com.gti.insurance_configuration.repositories.entities.PathConfiguration;
import com.gti.insurance_configuration.utils.constants.ErrorConstants;
import com.gti.insurance_configuration.utils.exceptions.NotFoundException;
import com.gti.insurance_configuration.utils.exceptions.UnsupportedFrequenceGenerationTypeException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PathConfigurationValidator {
    private final PathConfigurationRepository repository;

    public void validateForUpdate(PathConfigurationUpdateRequest request, Long id) {
        validateExists(id);
        validateFrequenceGenerationType(request.frequenceGenerationType());
    }

    private void validateFrequenceGenerationType(String frequenceGenerationType) {
        boolean isValid = switch (frequenceGenerationType) {
            case "QUOTIDIENNE", "MENSUELLE" -> true;
            default -> false;
        };
        if (!isValid) {
            throw new UnsupportedFrequenceGenerationTypeException(
                    ErrorConstants.FREQUENCE_GENERATION_TYPE_INVALID_MSG + frequenceGenerationType
            );
        }
    }

    public void validateExists(Long id) {
        if (!repository.existsById(id)) {
            throw new NotFoundException(
                    ErrorConstants.PATH_CONFIG_NOT_FOUND_MSG + id
            );
        }
    }
}
