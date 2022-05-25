package com.axonactive.companySpring3.service.impl;

import com.axonactive.companySpring3.entity.Department;
import com.axonactive.companySpring3.entity.DepartmentLocation;
import com.axonactive.companySpring3.entity.Location;
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

//not done?
class DepartmentLocationServiceImplTest {

    @Autowired
    DepartmentLocationServiceImpl departmentLocationService;
    @Autowired
    DepartmentServiceImpl departmentService;
    DepartmentLocation departmentLocation1;
    DepartmentLocation departmentLocation2;
    DepartmentLocation departmentLocation3;
    DepartmentLocation departmentLocation4;

    @BeforeEach
    void setup(){
        Department dep1 = new Department(1,"It",null);
        departmentService.saveDepartment(dep1);
        departmentLocation1 = DepartmentLocation.builder()
                .locations(Location.DANANG)
                .department(dep1)
                .build();
        departmentLocationService.saveDepartmentLocation(departmentLocation1);
        departmentLocation2 = DepartmentLocation.builder()
                .locations(Location.HCM)
                .department(dep1)
                .build();
        departmentLocationService.saveDepartmentLocation(departmentLocation2);
        Department dep2 = new Department(2,"HR",null);
        departmentService.saveDepartment(dep2);
        departmentLocation3 = DepartmentLocation.builder()
                .locations(Location.CANTHO)
                .department(dep2)
                .build();
        departmentLocationService.saveDepartmentLocation(departmentLocation3);
        departmentLocation4 = DepartmentLocation.builder()
                .locations(Location.HANOI)
                .department(null)
                .build();
        departmentLocationService.saveDepartmentLocation(departmentLocation4);

    }

    @Test
    void testGetAll_shouldReturn4_whenJustCreateTable() {
      List<DepartmentLocation> departmentLocation = departmentLocationService.getAll();
      assertEquals(4,departmentLocation.size());
    }

    @Test
    void saveDepartmentLocation() {
        assertEquals(4,departmentLocationService.getAll().size());
    }

    @Test
    void testFindById_shouldReturnDepartmentOfIdOf1_whenInsert1() {
        assertEquals(departmentLocation1,departmentLocationService.findById(1).get());
    }

    @Test
    void deleteDepartmentLocationById() {
        departmentLocationService.deleteDepartmentLocationById(1);
        assertEquals(3, departmentLocationService.getAll().size());
    }

    @Test
    void testFindByLocation_shouldReturnDepartmentLocaion1_whenInsertLocationOfDanang() {
        assertEquals(departmentLocation1,departmentLocationService.findByLocations(Location.DANANG));
    }

    @Test
    void testFindByLocationIn_shouldReturn2_whenInsertAListConsistedOfHCMAndDanang() {
        List<Location> locationList = new ArrayList<>();
        locationList.add(Location.HCM);
        locationList.add(Location.DANANG);
        assertEquals(2, departmentLocationService.findByLocationsIn(locationList).size());
    }

    @Test
    void testFindAllByOrderByLocation_shouldReturnAListOfDepartmentLocationOf3Then1Then2_whenRunTheMethod() {
        List<DepartmentLocation> departmentLocationList = new ArrayList<>();
        departmentLocationList.add(departmentLocation3);
        departmentLocationList.add(departmentLocation1);
        departmentLocationList.add(departmentLocation2);
        departmentLocationList.add(departmentLocation4);
        assertEquals(departmentLocationList,departmentLocationService.findAllByOrderByLocations());
    }

    @Test
    void testFindByDepartmentDepartmentName_shouldReturn2_whenInsertAStringOfIt() {
        assertEquals(2, departmentLocationService.findByDepartmentDepartmentName("It").size());
    }

    @Test
    void testFindByDepartmentDepartmentNameNot_shouldReturn2_whenInsertAStringOfIt() {
        assertEquals(1,departmentLocationService.findByDepartmentDepartmentNameNot("It").size());
    }

    @Test
    void testFindAllByOrderByDepartmentDepartmentName_shouldReturnAListConsistedOf3Then1Then2_whenRunTheMethod() {
        List<DepartmentLocation> departmentLocationList = new ArrayList<>();
        departmentLocationList.add(departmentLocation3);
        departmentLocationList.add(departmentLocation1);
        departmentLocationList.add(departmentLocation2);
        departmentLocationList.add(departmentLocation4);
        assertEquals(departmentLocationList,departmentLocationService.findAllByOrderByDepartmentDepartmentName());
    }

    @Test
    void testFindByDepartmentIsNull_shouldReturnDepartmentLocation4_whenRunTheMethod() {
        assertEquals(departmentLocation4, departmentLocationService.findByDepartmentIsNull().get(0));

    }
}