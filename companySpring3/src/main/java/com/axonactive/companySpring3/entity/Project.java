package com.axonactive.companySpring3.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer projectId;
    @NotNull
    private String area;
    @NotNull
    private String projectName;
    @ManyToOne
    @JoinColumn(name = "managed_department")
    private Department department;

}
