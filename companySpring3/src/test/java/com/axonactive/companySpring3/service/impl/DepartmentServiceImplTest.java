package com.axonactive.companySpring3.service.impl;

import com.axonactive.companySpring3.entity.Department;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class DepartmentServiceImplTest {

    @Autowired
    DepartmentServiceImpl departmentService;

    @Test
    void testGetAllDepartment_shouldReturnNoData_whenJustCreateTable() {
        List<Department> departments = departmentService.getAll();
        assertEquals(0,departments.size());

    }

    @Test
    void testSaveDepartment_shouldIncreaseTheDepartmentSizeBy1_whenAddOneDepartment(){
        Department department1 = Department.builder()
                .departmentName("IT")
                .startDate(null)
                .build();
        departmentService.saveDepartment(department1);
        assertEquals(1,departmentService.getAll().size());

    }

    @Test
    void testFindDepartmentById_shouldReturnTheDepartmentObject_whenSearchItsId() {
        Department department1 = new Department(1,"It",null);
        departmentService.saveDepartment(department1);
        assertEquals(department1,departmentService.findDepartmentById(1).get());
    }

    @Test
    void testDeleteDepartmentById_shouldReturnTheSizeOf0_whenDeleteTheId() {
        Department department1 = new Department(1,"It", null);
        departmentService.saveDepartment(department1);
        departmentService.deleteDepartmentById(1);
        assertEquals(0,departmentService.getAll().size());
    }
}