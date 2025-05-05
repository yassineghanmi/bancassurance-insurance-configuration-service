package com.gti.insurance_configuration.utils.validator;

import com.gti.insurance_configuration.models.requests.JokerInsuranceConfigCreateRequest;
import com.gti.insurance_configuration.models.requests.JokerInsuranceConfigUpdateRequest;
import com.gti.insurance_configuration.repositories.JokerInsuranceConfigurationRepository;
import com.gti.insurance_configuration.services.impl.ClientCategoryServiceImpl;
import com.gti.insurance_configuration.utils.constants.ErrorConstants;
import com.gti.insurance_configuration.utils.exceptions.ConfigConflictException;
import com.gti.insurance_configuration.utils.exceptions.NotFoundException;
import com.gti.insurance_configuration.utils.exceptions.UnsupportedClientCategoryException;
import com.gti.insurance_configuration.utils.exceptions.UnsupportedValidationLevelException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JokerInsuranceConfigurationValidator {
    private final JokerInsuranceConfigurationRepository repository;
    private final ClientCategoryServiceImpl categoryService;

    public void validateForCreate(JokerInsuranceConfigCreateRequest request) {
        validateProfilClient(request.profilClient());
        validateUniqueInsuranceData(request.assurance(),request.assureur(),request.profilClient());
        validateNiveauValidation(request.niveauValidation());
    }

    public void validateForUpdate(Long id, JokerInsuranceConfigUpdateRequest request) {
        validateExists(id);
        validateNiveauValidation(request.niveauValidation());
    }

    public void validateProfilClient(String profilClient){
        if(!categoryService.isValidClientCategory(profilClient)){
            throw new UnsupportedClientCategoryException(ErrorConstants.CLIENT_CATEGORY_INVALID_MSG + profilClient);
        }
    }

    public void validateUniqueInsuranceData(String assurance,String assureur,String profilClient){
        if(repository.existsJokerInsuranceConfigurationByAssuranceAndAssureurAndProfilClient(assurance,assureur,profilClient)){
            throw new ConfigConflictException(ErrorConstants.INSURANCE_CONFLICT_MSG + assurance + " "+ assureur + " " + profilClient);
        }
    }

    public void validateExists(Long id) {
        if (!repository.existsById(id)) {
            throw new NotFoundException(
                    ErrorConstants.JOKER_INSURANCE_CONFIG_NOT_FOUND_MSG + id
            );
        }
    }

    private void validateNiveauValidation(String niveauValidation) {
        if (!niveauValidation.equals("V1") && !niveauValidation.equals("V2")) {
            throw new UnsupportedValidationLevelException(
                    ErrorConstants.NIVEAU_VALIDATION_INVALID_MSG + niveauValidation
            );
        }
    }
}
