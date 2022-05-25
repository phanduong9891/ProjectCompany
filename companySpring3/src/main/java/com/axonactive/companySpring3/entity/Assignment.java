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
public class Assignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private Integer numberOfHour;
    @ManyToOne
    @JoinColumn(name = "employeeId")
    private Employee employee;
    @ManyToOne
    @JoinColumn(name = "projectId")
    private Project project;
}
