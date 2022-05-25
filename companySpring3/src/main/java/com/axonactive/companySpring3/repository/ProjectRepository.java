package com.axonactive.companySpring3.repository;

import com.axonactive.companySpring3.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ProjectRepository extends JpaRepository<Project,Integer> {
    Project findByProjectId(Integer id);
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
