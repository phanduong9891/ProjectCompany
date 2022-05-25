package com.axonactive.companySpring3.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employeeId;

    @NotNull
    @Column(unique = true)
    private String employeeIdFake;
    private LocalDate birthday;
    @NotNull
    private String firstName;
    private String gender;
    @NotNull
    private String lastName;
    @NotNull
    private String middleName;
    @NotNull
    private Integer salary;
    @ManyToOne
    @JoinColumn(name ="dept_id")
    private Department department;
}
