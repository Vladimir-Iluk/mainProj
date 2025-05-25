package com.iluk.git.mainProj.data;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "companies")
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Companie {

    @Id
    @GeneratedValue
    private Long company_id;

    private String name;

    @Column(name = "activity_type")
    private String activityType;

    private String address;

    private String phone;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Agreement> agreems;
}