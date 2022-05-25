package com.axonactive.companySpring3.repository;

import com.axonactive.companySpring3.entity.DepartmentLocation;
import com.axonactive.companySpring3.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentLocationRepository extends JpaRepository<DepartmentLocation,Integer> {
    DepartmentLocation findByLocations(Location location);
    List<DepartmentLocation> findByLocationsIn(List<Location> locations);
    List<DepartmentLocation> findAllByOrderByLocations();
    List<DepartmentLocation> findByDepartmentDepartmentName(String departmentName);
    List<DepartmentLocation> findByDepartmentDepartmentNameNot(String departmentName);

    List<DepartmentLocation> findAllByOrderByDepartmentDepartmentName();
    List<DepartmentLocation> findByDepartmentIsNull();



}
