package com.gti.insurance_configuration.utils.validator;

import com.gti.insurance_configuration.models.requests.PathConfigurationCreateRequest;
import com.gti.insurance_configuration.repositories.CompositeConfigRepository;
import com.gti.insurance_configuration.utils.constants.ErrorConstants;
import com.gti.insurance_configuration.utils.exceptions.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CompositeConfigValidator {
    private final CompositeConfigRepository repository;


    public void validateForCreate(PathConfigurationCreateRequest request,String insurance) {
        validateInsuranceNotExist(insurance);
        validateFrequenceGenerationType(request.frequenceGenerationType());
    }

    public void validateFrequenceGenerationType(String frequenceGenerationType) {
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

    public void validateInsuranceNotExist(String insurance){
        if(repository.existsByAssurance(insurance)){
            throw new ConfigConflictException(ErrorConstants.INSURANCE_CONFLICT_MSG + insurance);
        }
    }

    public void validateExists(Long id) {
        if (!repository.existsById(id)) {
            throw new NotFoundException(
                    ErrorConstants.COMPOSITE_CONFIG_NOT_FOUND_MSG + id
            );
        }
    }
}