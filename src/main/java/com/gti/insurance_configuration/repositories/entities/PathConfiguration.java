package com.gti.insurance_configuration.repositories.entities;

import com.fasterxml.jackson.annotation.*;
import com.gti.insurance_configuration.models.enums.FrequenceGenerationType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class PathConfiguration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cheminGeneration;
    private String cheminArchivage;
    private String cheminStreamServe;
    private String nomFichierStreamServe;
    @Enumerated(EnumType.STRING)
    private FrequenceGenerationType frequenceGenerationType;

    @OneToOne(mappedBy = "pathConfiguration")
    @JsonIgnore
    private ThresholdsConfiguration thresholdsConfiguration;

    @JsonProperty("thresholdsConfigurationId")
    public Long getThresholdsConfigurationId() {
        return thresholdsConfiguration != null ? thresholdsConfiguration.getId() : null;
    }

    @JsonProperty("thresholdsConfigurationAssurance")
    public String getThresholdsConfigurationAssurance(){
        return thresholdsConfiguration != null ? thresholdsConfiguration.getAssurance() : null;
    }
}
