package com.gti.insurance_configuration.repositories;

import com.gti.insurance_configuration.repositories.entities.JokerInsuranceConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface JokerInsuranceConfigurationRepository extends JpaRepository<JokerInsuranceConfiguration,Long> {

    @Query("SELECT J FROM JokerInsuranceConfiguration J WHERE (:assurance IS NULL OR J.assurance = :assurance) " +
            "AND (:profilClient IS NULL OR J.profilClient = :profilClient) " +
            "AND (:assureur IS NULL OR J.assureur = :assureur)")
    Page<JokerInsuranceConfiguration> findAllWithFilters(
            @Param("assureur") String assureur,
            @Param("assurance") String assurance,
            @Param("profilClient") String profilClient,
            Pageable pageable
    );

    boolean existsJokerInsuranceConfigurationByAssuranceAndAssureurAndProfilClient(String assurance,String assureur,String profilClient);
}
