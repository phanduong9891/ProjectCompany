package com.axonactive.companySpring3.repository;

import com.axonactive.companySpring3.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    Employee findByLastName(String lastName);
    List<Employee> findEmployeeByLastNameOrFirstName(String lastName, String firstName);
    Employee findByLastNameLike(String lastName);
    List<Employee> findBySalaryLessThan(Integer salary);
    List<Employee> findBySalaryGreaterThan(Integer salary);
    List<Employee> findBySalary(Integer salary);
    List<Employee> findBySalaryBetween(Integer minSalary, Integer maxSalary);
    List<Employee> findByLastNameIgnoreCase(String lastname);
    List<Employee> findByDepartmentDepartmentName(String departmentName);
    List<Employee> findByDepartmentDepartmentNameLike(String departmentName);
    List<Employee> findAllByOrderByDepartment();


}
