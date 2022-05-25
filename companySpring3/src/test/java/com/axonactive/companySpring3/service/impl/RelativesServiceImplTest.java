package com.axonactive.companySpring3.service.impl;

import com.axonactive.companySpring3.entity.Department;
import com.axonactive.companySpring3.entity.Employee;
import com.axonactive.companySpring3.entity.Relatives;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;
@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class RelativesServiceImplTest {
    @Autowired
    RelativesServiceImpl relativesService;

    @Autowired
    EmployeeServiceImpl employeeService;

    @Autowired
    DepartmentServiceImpl departmentService;

    Relatives relatives1;
    Relatives relatives2;
    Relatives relatives3;
    Relatives relatives4;
    Relatives relatives5;

    @BeforeEach
    void setup(){
        Department dep1 = new Department(1,"It",LocalDate.of(2000,1,1));
        departmentService.saveDepartment(dep1);
        Employee employee1 = new Employee(1,"1", LocalDate.of(1990,8,13),"Quang","female","Ly","Minh",880,dep1);
        employeeService.saveEmployee(employee1);
        relatives1 = new Relatives(1,"MamaQuang",1,"0111111123","Mama",employee1);
        relativesService.saveRelatives(relatives1);

        Employee employee2 = new Employee(2,"2", LocalDate.of(1995,9,20),"Minh","male","Le","Minh",1200,dep1);
        employeeService.saveEmployee(employee2);
        relatives2 = new Relatives(2,"Thang",0,"01111111124","Papa",employee2);
        relativesService.saveRelatives(relatives2);

        Department dep2 = new Department(2,"HR",LocalDate.of(2002,1,1));
        departmentService.saveDepartment(dep2);
        Employee employee3 = new Employee(3,"3", LocalDate.of(2000,12,25),"Nhi","female","Nguyen","An",2200,dep2);
        employeeService.saveEmployee(employee3);
        relatives3 = new Relatives(3,"Phong",1,"01111111125","Mama",employee3);
        relativesService.saveRelatives(relatives3);

        Employee employee4 = new Employee(4,"4", LocalDate.of(1985,1,1),"Hanh","male","Manh","Thanh",1500,dep2);
        employeeService.saveEmployee(employee4);
        relatives4 = new Relatives(4,"Van",1,"011111111126","Sister",employee4);
        relativesService.saveRelatives(relatives4);

        relatives5 = new Relatives(5,"Haha",1,"011111111127","Mama",null);
        relativesService.saveRelatives(relatives5);

    }

    @Test
    void testGetAll_shouldReturnNoData_whenJustCreateTable() {
        List<Relatives> relativesList = relativesService.getAll();
        Assertions.assertEquals(5,relativesList.size());
    }

    @Test
    void testSaveRelatives_shouldGetTheEmployee_whenAddTheEmployeeToTheTable() {

        Assertions.assertEquals(relatives1,relativesService.getAll().get(0));
    }

    @Test
    void testFindRelativesById_shouldReturnTheSearchedEmployee_whenFindThatEmployeeWithId() {

        Assertions.assertEquals(relatives1,relativesService.findRelativesById(1).get());
    }

    @Test
    void testDeleteRelativesById_shouldReturnFalse_whenSearchTheEmployeeAfterDeletedThatEmployee() {
        relativesService.deleteRelativesById(1);
        Assertions.assertFalse(relativesService.findRelativesById(1).isPresent());
    }

    @Test
    void testFindByFullName_shouldReturnRelatives1_whenInsertFullNameOfRelatives1() {
        Assertions.assertEquals(relatives1,relativesService.findByFullName("MamaQuang"));
    }

    @Test
    void testFindByOrderByFullName_shouldReturnRelative5AtIndex0_whenRunMethod() {
        Assertions.assertEquals(relatives5,relativesService.findByOrderByFullName().get(0));
    }

    @Test
    void testFindByGender_shouldReturn4_whenInsertGenderNumberOf1() {
        Assertions.assertEquals(4,relativesService.findByGender(1).size());
    }

    @Test
    void testFindByPhoneNumberIgnoreCase_shouldReturnRelative1_whenInsertPhoneNumberOfRelatives1() {
        Assertions.assertEquals(relatives1,relativesService.findByPhoneNumberIgnoreCase("0111111123"));
    }

    @Test
    void testFindByRelationshipIgnoreCase_shouldReturn1_whenInsertRelationshipOfPapa() {
        Assertions.assertEquals(1,relativesService.findByRelationshipIgnoreCase("papa").size());
    }

    @Test
    void testFindByEmployeeIsNull_shouldReturnRelatives5_whenRunTheMethod() {
        Assertions.assertEquals(relatives5,relativesService.findByEmployeeIsNull().get(0));
    }

    @Test
    void testFindByEmployeeEmployeeId_shouldReturnRelatives1_whenInsertIdOf1() {
        Assertions.assertEquals(relatives1, relativesService.findByEmployeeEmployeeId(1));
    }

    @Test
    void testFindByEmployeeFirstNameContainingIgnoreCase_shouldReturn4_whenInsertAStringOfN() {
        Assertions.assertEquals(3,relativesService.findByEmployeeFirstNameContainingIgnoreCase("h").size());
    }

    @Test
    void testFindByOrderByEmployeeFirstName_shouldReturnRelatives4_whenGetRelativesAtIndex0() {
        Assertions.assertEquals(relatives4,relativesService.findByOrderByEmployeeFirstName().get(0));
    }

    @Test
    void testFindByEmployeeSalaryGreaterThan_shouldReturn3_whenInsertAnInputOf1000() {
        Assertions.assertEquals(3,relativesService.findByEmployeeSalaryGreaterThan(1000).size());
    }

    @Test
    void testFindByEmployeeDepartmentDepartmentNameIgnoreCase_shouldReturn2_whenInsertAStringOfIt() {
        Assertions.assertEquals(2,relativesService.findByEmployeeDepartmentDepartmentNameIgnoreCase("it").size());
    }

    @Test
    void testFindByEmployeeBirthdayBefore_shouldReturn2_whenInsertABirthdayOf200011() {
        Assertions.assertEquals(3,relativesService.findByEmployeeBirthdayBefore(LocalDate.of(2000,1,1)).size());
    }
}