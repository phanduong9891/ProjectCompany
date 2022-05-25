package com.axonactive.companySpring3.service;

import com.axonactive.companySpring3.entity.Assignment;

import java.util.List;
import java.util.Optional;

public interface AssignmentService {
    List<Assignment> getAll();

    void saveAssignment(Assignment assignment);

    Optional<Assignment> findAssignmentById(Integer id);

    void deleteAssignmentById(Integer id);

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
