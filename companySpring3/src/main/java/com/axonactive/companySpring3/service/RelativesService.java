package com.axonactive.companySpring3.service;

import com.axonactive.companySpring3.entity.Department;
import com.axonactive.companySpring3.entity.Relatives;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface RelativesService {
    List<Relatives> getAll();

    void saveRelatives(Relatives relatives);

    Optional<Relatives> findRelativesById(Integer id);

    void deleteRelativesById(Integer id);

    Relatives findByFullName(String fullName);
    List<Relatives> findByOrderByFullName();
    List<Relatives> findByGender(Integer number1Or0);
    Relatives findByPhoneNumberIgnoreCase(String phoneNum);
    List<Relatives> findByRelationshipIgnoreCase(String relationship);
    List<Relatives> findByEmployeeIsNull();
    Relatives findByEmployeeEmployeeId(Integer id);
    List<Relatives> findByEmployeeFirstNameContainingIgnoreCase(String name);
    List<Relatives> findByOrderByEmployeeFirstName();
    List<Relatives> findByEmployeeSalaryGreaterThan(Integer salary);
    List<Relatives> findByEmployeeDepartmentDepartmentNameIgnoreCase(String departmentName);
    List<Relatives> findByEmployeeBirthdayBefore(LocalDate date);
}
