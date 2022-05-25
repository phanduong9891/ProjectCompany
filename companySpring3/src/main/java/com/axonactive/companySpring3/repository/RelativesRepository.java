package com.axonactive.companySpring3.repository;

import com.axonactive.companySpring3.entity.Relatives;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface RelativesRepository extends JpaRepository<Relatives,Integer> {
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
