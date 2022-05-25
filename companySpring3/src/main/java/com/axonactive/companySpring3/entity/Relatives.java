package com.axonactive.companySpring3.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Relatives {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private String fullName;
    @NotNull
    private Integer gender;
    @NotNull
    private String phoneNumber;
    @NotNull
    private String relationship;
    @ManyToOne
    @JoinColumn(name = "employeeId")
    private Employee employee;
}
