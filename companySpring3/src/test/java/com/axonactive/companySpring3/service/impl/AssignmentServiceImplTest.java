package com.axonactive.companySpring3.service.impl;

import com.axonactive.companySpring3.entity.Assignment;
import com.axonactive.companySpring3.entity.Department;
import com.axonactive.companySpring3.entity.Employee;
import com.axonactive.companySpring3.entity.Project;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class AssignmentServiceImplTest {
    @Autowired
    AssignmentServiceImpl assignmentService;
    @Autowired
    DepartmentServiceImpl departmentService;
    @Autowired
    EmployeeServiceImpl employeeService;
    @Autowired
    ProjectServiceImpl projectService;

    Assignment assignment1;
    Assignment assignment2;


    @BeforeEach
    void setup(){
        Department dep1 = new Department(1,"It",null);
        departmentService.saveDepartment(dep1);

        Project project1 = new Project(1,"HCM","Buy computer",dep1);
        projectService.saveProject(project1);

        Employee employee1 = new Employee(1,"1",null,"Quang","female","Ly","Minh",880,dep1);
        employeeService.saveEmployee(employee1);

        assignment1 = new Assignment(1,100,employee1,project1);
        assignmentService.saveAssignment(assignment1);


        Department dep2 = new Department(2,"Marketing",null);
        departmentService.saveDepartment(dep2);

        Project project2 = new Project(2,"HCM","Run campaign",dep2);
        projectService.saveProject(project2);

        Employee employee2 = new Employee(2,"2",null,"Phu","male","Le","Thanh",880,dep2);
        employeeService.saveEmployee(employee2);

        assignment2 = new Assignment(2,200,employee2,project2);
        assignmentService.saveAssignment(assignment2);
    }

    @Test
    void getAll() {
        List<Assignment> assignmentList = assignmentService.getAll();
        assertEquals(2,assignmentList.size());

    }

    @Test
    void saveAssignment() {
        assertEquals(2,assignmentService.getAll().size());
    }

    @Test
    void findAssignmentById() {
        assertTrue(assignmentService.findAssignmentById(1).isPresent());
    }

    @Test
    void testDeleteAssignmentById_shouldReturnFall_whenTryToFindAssignmentWithIdOf1() {
        assignmentService.deleteAssignmentById(1);
        assertFalse(assignmentService.findAssignmentById(1).isPresent());
    }

    @Test
    void testFindByNumberOfHour_shouldReturnAssignment1_whenFindByNumberOfHourOf100() {
        assertEquals(assignment1, assignmentService.findByNumberOfHour(100));

    }

    @Test
    void testFindByEmployeeEmployeeId_shouldReturnAssignment1_whenFindByEmployeeIdOf1() {
        assertEquals(assignment1,assignmentService.findByEmployeeEmployeeId(1));
    }

    @Test
    void testFindByProjectProjectId_shouldReturnAssignment1_whenFindByProjectIdOf1() {
        assertEquals(assignment1,assignmentService.findByProjectProjectId(1));
    }

    @Test
    void testFindByNumberOfHourLessThan_shouldReturnAssignment1_whenFindByNumberOfHourLessThan200() {
        assertEquals(assignment1,assignmentService.findByNumberOfHourLessThan(200).get(0));
    }

    @Test
    void testFindByNumberOfHourBetween_shouldReturnAssignment1_whenFindByNumberOfHourBetween500and150() {
        assertEquals(assignment1,assignmentService.findByNumberOfHourBetween(50,150).get(0));
    }

    @Test
    void testFindByNumberOfHourGreaterThanOrderById_shouldReturnAssignment1ThenAssignment2_whenInsertParameterOf50() {
        List<Assignment> expectedList = new ArrayList<>();
        expectedList.add(assignment1);
        expectedList.add(assignment2);
        List<Assignment> actualList = assignmentService.findByNumberOfHourGreaterThanOrderById(50);

        assertEquals(expectedList,actualList);
    }

    @Test
    void testFindByEmployeeLastName_shouldReturn1_whenInsertLastNameOfLe() {
        assertEquals(1,assignmentService.findByEmployeeLastName("Le").size());
    }

    @Test
    void testFindByEmployeeDepartmentId_shouldReturn1_whenInsertDepartmentIdOf1() {
        assertEquals(1,assignmentService.findByEmployeeDepartmentId(1).size());
    }

    @Test
    void testFindByEmployeeDepartmentDepartmentName_shouldReturnAssignment2_whenInsertDepartmentNameOfMarketing() {
        assertEquals(assignment2,assignmentService.findByEmployeeDepartmentDepartmentName("Marketing").get(0));
    }
}