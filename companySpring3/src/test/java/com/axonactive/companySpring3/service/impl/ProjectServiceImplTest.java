package com.axonactive.companySpring3.service.impl;

import com.axonactive.companySpring3.entity.Department;
import com.axonactive.companySpring3.entity.Project;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class ProjectServiceImplTest {
    @Autowired
    ProjectServiceImpl projectService;
    @Autowired
    DepartmentServiceImpl departmentService;

    Project project1;
    Project project2;
    Project project3;

    @Test
    void testGetAll_shouldReturnNoData_whenJustCreateTable() {
        List<Project> projects = projectService.getAll();
        assertEquals(3,projects.size());
    }

    @BeforeEach
    void setup(){
        Department dep1 = new Department(1,"It", LocalDate.of(2022,1,1));
        departmentService.saveDepartment(dep1);
        project1 = Project.builder()
                .projectName("Sell old computer")
                .area("HCM")
                .department(dep1)
                .build();
        projectService.saveProject(project1);
        project2 = Project.builder()
                .projectName("Buy new computer")
                .area("HCM")
                .department(dep1)
                .build();
        projectService.saveProject(project2);
        Department dep2 = new Department(2,"HR",null);
        departmentService.saveDepartment(dep2);
        project3 = Project.builder()
                .projectName("Hire new employee")
                .area("CanTho")
                .department(dep2)
                .build();
        projectService.saveProject(project3);
    }

    @Test
    void testSaveProject_shouldReturnTheSizeOf1_whenAdd1ProjectToTheProjectRepository() {
        assertEquals(3,projectService.getAll().size());
    }

    @Test
    void testFindProjectById_shouldTheReturnTheSearchedProject_whenSearchThatProjectById() {
        assertEquals(project1,projectService.findProjectById(1).get());
    }

    @Test
    void testDeleteProjectById_shouldReturnSizeEqual0_whenDelete() {
        projectService.deleteProjectById(1);
        assertFalse(projectService.findProjectById(1).isPresent());
    }


    @Test
    void testFindByProjectName_shouldReturnProject2_whenInsertProjectNameBuyNewComputer() {
        assertEquals(project2,projectService.findByProjectName("Buy new computer"));
    }

    @Test
    void testFindProjectByDepartmentDepartmentName_shouldReturn2_whenInsertDepartmentNameOfIt() {
        assertEquals(2,projectService.findProjectByDepartmentDepartmentName("It").size());
    }

    @Test
    void testFindByProjectNameIgnoreCase_shouldReturnProject2_whenInsertNonCapProjectNameBuyNewComputer() {
        assertEquals(project2,projectService.findByProjectNameIgnoreCase("buy new computer"));
    }

    @Test
    void testFindByArea_shouldReturn2_whenInsertAreaOfHCM() {
        assertEquals(2,projectService.findByArea("HCM").size());
    }

    @Test
    void testFindByAreaOrderByProjectName_shouldReturnAListOfProject2ThenProject1_whenInsertAreaOfHCM() {
        List<Project> expectedList = new ArrayList<>();
        expectedList.add(project2);
        expectedList.add(project1);
        assertEquals(expectedList,projectService.findByAreaOrderByProjectName("HCM"));
    }

    @Test
    void testFindByDepartmentStartDate_shouldReturn2_whenInsertStartDateOf1stJanuary2022() {
        assertEquals(2,projectService.findByDepartmentStartDate(LocalDate.of(2022,1,1)).size());
    }

    @Test
    void testFindByProjectNameContaining_shouldReturn2_whenInsertAStringOfComputer() {
        assertEquals(2,projectService.findByProjectNameContaining("computer").size());
    }

    @Test
    void testFindByDepartmentDepartmentNameOrderByProjectName_shouldReturnAListOfProject2ThenProject1_whenInsertIt() {
        List<Project> expectedList = new ArrayList<>();
        expectedList.add(project2);
        expectedList.add(project1);
        assertEquals(expectedList,projectService.findByDepartmentDepartmentNameOrderByProjectName("It"));
    }

    @Test
    void testFindByDepartmentDepartmentNameNot_shouldReturn1_whenInsertIt() {
        assertEquals(1,projectService.findByDepartmentDepartmentNameNot("It").size());
    }
}