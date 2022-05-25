package com.axonactive.companySpring3.service.impl;

import com.axonactive.companySpring3.entity.Employee;
import com.axonactive.companySpring3.repository.EmployeeRepository;
import com.axonactive.companySpring3.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);

    }

    @Override
    public Optional<Employee> findEmployeeById(String id) {
        return employeeRepository.findById(Integer.valueOf(id));
    }

    @Override
    public void deleteEmployeeById(String id) {
        employeeRepository.deleteById(Integer.valueOf(id));

    }

    @Override
    public Employee findByLastName(String lastname) {
        return employeeRepository.findByLastName(lastname);
    }

    @Override
    public List<Employee> findEmployeeByLastNameOrFirstName(String lastName, String firstName) {
        return employeeRepository.findEmployeeByLastNameOrFirstName(lastName, firstName);
    }

    @Override
    public Employee findByLastNameLike(String lastNameLike) {
        return employeeRepository.findByLastNameLike(lastNameLike);
    }

    @Override
    public List<Employee> findBySalaryLessThan(Integer salary) {
        return employeeRepository.findBySalaryLessThan(salary);
    }

    @Override
    public List<Employee> findBySalaryGreaterThan(Integer salary) {
        return employeeRepository.findBySalaryGreaterThan(salary);
    }

    @Override
    public List<Employee> findBySalary(Integer salary) {
        return employeeRepository.findBySalary(salary);
    }

    @Override
    public List<Employee> findBySalaryBetween(Integer minSalary, Integer maxSalary) {
        return employeeRepository.findBySalaryBetween(minSalary,maxSalary);
    }

    @Override
    public List<Employee> findByLastNameIgnoreCase(String lastname) {
        return employeeRepository.findByLastNameIgnoreCase(lastname);
    }

    @Override
    public List<Employee> findByDepartmentDepartmentName(String departmentName) {
        return employeeRepository.findByDepartmentDepartmentName(departmentName);
    }

    @Override
    public List<Employee> findByDepartmentDepartmentNameLike(String departmentName) {
        return employeeRepository.findByDepartmentDepartmentNameLike(departmentName);
    }

    @Override
    public List<Employee> findAllByOrderByDepartment() {
        return employeeRepository.findAllByOrderByDepartment();
    }


}
