package com.axonactive.companySpring3.service;

import com.axonactive.companySpring3.entity.Department;
import com.axonactive.companySpring3.entity.Project;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ProjectService {
    List<Project> getAll();

    void saveProject(Project project);

    Optional<Project> findProjectById(Integer id);

    void deleteProjectById(Integer id);

    Project findByProjectName(String name);
    List<Project> findProjectByDepartmentDepartmentName(String name);
    Project findByProjectNameIgnoreCase(String name);
    List<Project> findByArea(String are);
    List<Project> findByAreaOrderByProjectName(String area);
    List<Project> findByDepartmentStartDate(LocalDate date);
    List<Project> findByProjectNameContaining(String name);
    List<Project> findByDepartmentDepartmentNameOrderByProjectName(String departmentName);
    List<Project> findByDepartmentDepartmentNameNot(String departmentName);
}
