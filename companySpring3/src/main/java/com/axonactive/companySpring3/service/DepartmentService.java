package com.axonactive.companySpring3.service;

import com.axonactive.companySpring3.entity.Department;

import java.util.List;
import java.util.Optional;

public interface DepartmentService{
    List<Department> getAll();

    void saveDepartment(Department department);

    Optional<Department> findDepartmentById(Integer id);

    void deleteDepartmentById(Integer id);
}
