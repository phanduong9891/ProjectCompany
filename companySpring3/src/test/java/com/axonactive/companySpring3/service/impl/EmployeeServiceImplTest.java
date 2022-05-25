package com.axonactive.companySpring3.service.impl;

import com.axonactive.companySpring3.entity.Department;
import com.axonactive.companySpring3.entity.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class EmployeeServiceImplTest {

    @Autowired
    EmployeeServiceImpl employeeService;

    @Autowired
    DepartmentServiceImpl departmentService;

    private Department dep1;
    private Employee employee1;

    @Test
    void saveEmployee() {

        assertEquals(1,employeeService.getAll().size());

    }

    @BeforeEach
    void setup(){
        dep1 = new Department(1,"It",null);
        departmentService.saveDepartment(dep1);

        employee1 = Employee.builder()
                .employeeIdFake("1")
                .birthday(null)
                .firstName("Quang")
                .middleName("Ly")
                .lastName("Phong")
                .gender("Male")
                .salary(500)
                .department(dep1)
                .build();
        employeeService.saveEmployee(employee1);
    }

    @Test
    void testGetAll_shouldReturnNoData_whenJustCreateTable() {
        List<Employee> employees= employeeService.getAll();
        assertEquals(0,employees.size());
    }




    @Test
    void findEmployeeById() {
        assertEquals(employee1,employeeService.findEmployeeById("1").get());
    }

    @Test
    void deleteEmployeeById() {

        employeeService.deleteEmployeeById("1");
        assertEquals(0,employeeService.getAll().size());
    }


    @Test
    void findByLastName() {

        employeeService.saveEmployee(employee1);
        assertEquals(employee1,employeeService.findByLastName("Phong"));
    }

    @Test
    void findByLastNameOrFirstName() {
        employeeService.saveEmployee(employee1);
        Employee employee2 = Employee.builder()
                .employeeIdFake("2")
                .birthday(null)
                .firstName("Quang")
                .middleName("Ly")
                .lastName("Ly")
                .gender("Male")
                .salary(500)
                .department(dep1)
                .build();
        employeeService.saveEmployee(employee2);

        assertEquals(2,employeeService.findEmployeeByLastNameOrFirstName("Phong","Quang").size());
//        assertEquals(employee1,employeeService.findEmployeeByLastNameOrFirstName("Quang"));
    }

    @Test
    void testFindByLastNameLike_shouldReturnEmployeeWithLastNameLikeP_whenFindLastnameLikeP() {
        employeeService.saveEmployee(employee1);
        assertEquals(employee1,employeeService.findByLastNameLike("P%"));
    }

    @Test
    void findBySalaryLessThan4000() {
        employeeService.saveEmployee(employee1);
        assertEquals(1,employeeService.findBySalaryLessThan(4000).size());
    }

    @Test
    void findBySalaryGreaterThan() {
        employeeService.saveEmployee(employee1);
        assertEquals(0,employeeService.findBySalaryGreaterThan(4000).size());
    }

    @Test
    void findByDepartmentDepartmentName() {
        assertEquals(employee1,employeeService.findByDepartmentDepartmentName("It").get(0));

    }

    @Test
    void findByDepartmentDepartmentNameLike() {
        assertEquals(employee1,employeeService.findByDepartmentDepartmentNameLike("%t").get(0));
    }

    @Test
    void findBySalary() {
        assertEquals(employee1,employeeService.findBySalary(500).get(0));
    }

    @Test
    void findBySalaryBetween() {
        assertEquals(employee1,employeeService.findBySalaryBetween(300,600).get(0));
    }

    @Test
    void findByLastNameIgnoreCase() {
        assertEquals(employee1,employeeService.findByLastNameIgnoreCase("phong").get(0));
    }

    @Test
    void findAllByOrderByDepartment() {
        assertEquals(1,employeeService.findAllByOrderByDepartment().size());
    }
}