package com.iluk.git.mainProj.data;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "employers")
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Employer {

    @Id
    @GeneratedValue
    private Long employer_id;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    private String qualification;

    @Column(name = "activity_type")
    private String activityType;

    @Column(name = "other_info")
    private String otherInfo;

    @Column(name = "expected_salary")
    private BigDecimal expectedSalary;

    @OneToMany(mappedBy = "empl", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Agreement> Agreements;
}