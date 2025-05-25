package com.iluk.git.mainProj.data;

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
    @GeneratedValue
    private Long agreement_id;

    @ManyToOne
    @JoinColumn(name = "employer_id", nullable = false)
    @ToString.Exclude
    private Employer empl;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    @ToString.Exclude
    private Companie company;

    private String position;
    private BigDecimal commission;
}