package com.gti.insurance_configuration.repositories.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class DelayConfiguration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int delaiAnnulation;
    private int delaiResiliation;
    @OneToOne(mappedBy = "delayConfiguration")
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
