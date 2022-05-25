package com.axonactive.companySpring3.service;

import com.axonactive.companySpring3.entity.Department;
import com.axonactive.companySpring3.entity.DepartmentLocation;
import com.axonactive.companySpring3.entity.Location;

import java.util.List;
import java.util.Optional;

public interface DepartmentLocationService {
    List<DepartmentLocation> getAll();

    void saveDepartmentLocation(DepartmentLocation departmentLocation);

    Optional<DepartmentLocation> findById(Integer id);

    void deleteDepartmentLocationById(Integer id);

    DepartmentLocation findByLocations(Location location);
    List<DepartmentLocation> findByLocationsIn(List<Location> locations);
    List<DepartmentLocation> findAllByOrderByLocations();
    List<DepartmentLocation> findByDepartmentDepartmentName(String departmentName);
    List<DepartmentLocation> findByDepartmentDepartmentNameNot(String departmentName);

    List<DepartmentLocation> findAllByOrderByDepartmentDepartmentName();
    List<DepartmentLocation> findByDepartmentIsNull();
}
