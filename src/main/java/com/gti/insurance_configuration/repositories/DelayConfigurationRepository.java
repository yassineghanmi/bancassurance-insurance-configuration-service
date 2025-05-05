package com.gti.insurance_configuration.repositories;

import com.gti.insurance_configuration.repositories.entities.DelayConfiguration;
import com.gti.insurance_configuration.repositories.entities.PathConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DelayConfigurationRepository extends JpaRepository<DelayConfiguration,Long> {
    @Query("SELECT D FROM DelayConfiguration D WHERE :thresholdsConfigurationAssurance IS NULL OR D.thresholdsConfiguration.assurance = :thresholdsConfigurationAssurance")
    Page<DelayConfiguration> findAllWithFilters(
            @Param("thresholdsConfigurationAssurance") String thresholdsConfigurationAssurance,
            Pageable pageable
    );
}
