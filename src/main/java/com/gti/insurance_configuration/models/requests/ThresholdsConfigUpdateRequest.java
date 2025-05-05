package com.gti.insurance_configuration.models.requests;

public record ThresholdsConfigUpdateRequest(String assurance,
                                            Double seuilMontant,
                                            Integer seuilAge,
                                            Boolean maladie,
                                            Boolean compteJoint,
                                            Boolean rembNonMensuel,
                                            Boolean franchise) {
}
