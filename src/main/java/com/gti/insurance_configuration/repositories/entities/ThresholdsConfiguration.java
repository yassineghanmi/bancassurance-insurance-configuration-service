package com.gti.insurance_configuration.repositories.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class ThresholdsConfiguration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String assurance;
    private double seuilMontant;
    private int seuilAge;
    private boolean maladie;
    private boolean compteJoint;
    private boolean rembNonMensuel;
    private boolean franchise;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "delay_config_id")
    @JsonManagedReference
    private DelayConfiguration delayConfiguration;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "path_config_id")
    @JsonManagedReference
    private PathConfiguration pathConfiguration;

}
