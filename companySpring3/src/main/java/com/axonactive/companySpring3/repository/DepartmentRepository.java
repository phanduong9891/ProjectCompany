package com.axonactive.companySpring3.repository;

import com.axonactive.companySpring3.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
