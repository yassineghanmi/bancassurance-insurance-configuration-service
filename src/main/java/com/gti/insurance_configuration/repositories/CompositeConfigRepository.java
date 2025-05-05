package com.gti.insurance_configuration.repositories;

import com.gti.insurance_configuration.repositories.entities.ThresholdsConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CompositeConfigRepository extends JpaRepository<ThresholdsConfiguration,Long> {
    @Query("SELECT T FROM ThresholdsConfiguration T WHERE :assurance IS NULL OR T.assurance = :assurance")
    Page<ThresholdsConfiguration> findAllWithFilters(
            @Param("assurance") String thresholdsConfigurationAssurance,
            Pageable pageable
    );
    boolean existsByAssurance(String insurance);
}
