package com.iluk.git.mainProj.data.Entitys;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity
@Table(name = "agreements")
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Agreement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "agreement_id")
    private Long agreementId;


    @ManyToOne
    @JoinColumn(name = "employer_id", nullable = false)
    @ToString.Exclude
    private Employer empl;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    @ToString.Exclude
    private Companie company;

    private String pos;
    private BigDecimal commission;
}