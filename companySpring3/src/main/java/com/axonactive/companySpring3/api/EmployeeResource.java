package com.axonactive.companySpring3.api;

import com.axonactive.companySpring3.entity.Department;
import com.axonactive.companySpring3.entity.Employee;
import com.axonactive.companySpring3.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(maxAge = 3600)
@RequestMapping("/api/employees")
public class EmployeeResource {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/get")
    public List<Employee> getAllDepartment(){
        List<Employee> employees = employeeService.getAll();
        return  employees;
    }

    @PostMapping("/add")
    public void addEmployee(@RequestBody Employee employee){
        employeeService.saveEmployee(employee);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable(value = "id") Integer id) {
        Employee employee = employeeService.findEmployeeById(String.valueOf(id)).get();

        employeeService.deleteEmployeeById(employee.getEmployeeIdFake());
    }
    @GetMapping("/find1/{lastname}")
    public Employee findByLastName(@PathVariable(value = "lastname") String lastname) throws ResourceNotFoundException{
        Employee employee = employeeService.findByLastName(lastname);
        return employee;
    }
    @GetMapping("find2/{salary}")
    public List<Employee> findBySalaryGreaterThan(@PathVariable(value = "salary")Integer salary){
        List<Employee> employeeList = employeeService.findBySalaryGreaterThan(salary);

        return employeeList;
    }


}
