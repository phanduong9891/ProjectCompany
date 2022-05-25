package com.axonactive.companySpring3.service;

import com.axonactive.companySpring3.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<Employee> getAll();

    void saveEmployee(Employee employee);

    Optional<Employee> findEmployeeById(String id);

    void deleteEmployeeById(String id);

    Employee findByLastName(String lastName);

    List<Employee> findEmployeeByLastNameOrFirstName(String lastName, String firstName);

    Employee findByLastNameLike(String lastNameLike);

    List<Employee> findBySalaryLessThan(Integer salary);

    List<Employee> findBySalaryGreaterThan(Integer salary);

    List<Employee> findBySalary(Integer salary);

    List<Employee> findBySalaryBetween(Integer minSalary, Integer maxSalary);

    List<Employee> findByLastNameIgnoreCase(String lastname);

    List<Employee> findByDepartmentDepartmentName(String departmentName);

    List<Employee> findByDepartmentDepartmentNameLike(String departmentName);

    List<Employee> findAllByOrderByDepartment();

}
