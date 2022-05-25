package com.axonactive.companySpring3.repository;

import com.axonactive.companySpring3.entity.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AssignmentRepository extends JpaRepository<Assignment,Integer> {

    Assignment findByNumberOfHour (Integer numberOfHour);
    Assignment findByEmployeeEmployeeId(Integer id);
    Assignment findByProjectProjectId(Integer id);
    List<Assignment> findByNumberOfHourLessThan(Integer numberOfHour);
    List<Assignment> findByNumberOfHourBetween(Integer minNumberOfHour, Integer maxNumberOfHour);
    List<Assignment> findByNumberOfHourGreaterThanOrderById(Integer numberOfHour);
    List<Assignment> findByEmployeeLastName(String name);
    List<Assignment> findByEmployeeDepartmentId (Integer id);
    List<Assignment> findByEmployeeDepartmentDepartmentName(String departmentName);

}
