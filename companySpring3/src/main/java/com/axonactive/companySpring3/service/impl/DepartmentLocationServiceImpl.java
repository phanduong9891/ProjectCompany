package com.axonactive.companySpring3.service.impl;


import com.axonactive.companySpring3.entity.DepartmentLocation;
import com.axonactive.companySpring3.entity.Location;
import com.axonactive.companySpring3.repository.DepartmentLocationRepository;
import com.axonactive.companySpring3.service.DepartmentLocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DepartmentLocationServiceImpl implements DepartmentLocationService {

    private final DepartmentLocationRepository departmentLocationRepository;

    @Override
    public List<DepartmentLocation> getAll() {
        return departmentLocationRepository.findAll() ;
    }

    @Override
    public void saveDepartmentLocation(DepartmentLocation departmentLocation) {
        departmentLocationRepository.save(departmentLocation);
    }

    @Override
    public Optional<DepartmentLocation> findById(Integer id) {
        return departmentLocationRepository.findById(id);
    }

    @Override
    public void deleteDepartmentLocationById(Integer id) {
        departmentLocationRepository.deleteById(id);

    }

    @Override
    public DepartmentLocation findByLocations(Location location) {
        return departmentLocationRepository.findByLocations(location);
    }

    @Override
    public List<DepartmentLocation> findByLocationsIn(List<Location> locations) {
        return departmentLocationRepository.findByLocationsIn(locations);
    }

    @Override
    public List<DepartmentLocation> findAllByOrderByLocations() {
        return departmentLocationRepository.findAllByOrderByLocations();
    }

    @Override
    public List<DepartmentLocation> findByDepartmentDepartmentName(String departmentName) {
        return departmentLocationRepository.findByDepartmentDepartmentName(departmentName);
    }

    @Override
    public List<DepartmentLocation> findByDepartmentDepartmentNameNot(String departmentName) {
        return departmentLocationRepository.findByDepartmentDepartmentNameNot(departmentName);
    }

    @Override
    public List<DepartmentLocation> findAllByOrderByDepartmentDepartmentName() {
        return departmentLocationRepository.findAllByOrderByDepartmentDepartmentName();
    }

    @Override
    public List<DepartmentLocation> findByDepartmentIsNull() {
        return departmentLocationRepository.findByDepartmentIsNull();
    }
}
