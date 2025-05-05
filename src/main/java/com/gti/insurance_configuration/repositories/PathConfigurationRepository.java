package com.gti.insurance_configuration.repositories;

import com.gti.insurance_configuration.repositories.entities.PathConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PathConfigurationRepository extends JpaRepository<PathConfiguration,Long> {

    @Query("SELECT P FROM PathConfiguration P WHERE :thresholdsConfigurationAssurance IS null OR P.thresholdsConfiguration.assurance = :thresholdsConfigurationAssurance")
    Page<PathConfiguration> findAllWithFilters(
            @Param("thresholdsConfigurationAssurance") String thresholdsConfigurationAssurance,
            Pageable pageable
    );
}
