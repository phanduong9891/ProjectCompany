package com.axonactive.companySpring3.service.impl;

import com.axonactive.companySpring3.entity.Relatives;
import com.axonactive.companySpring3.repository.RelativesRepository;
import com.axonactive.companySpring3.service.RelativesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RelativesServiceImpl implements RelativesService {
    private final RelativesRepository relativesRepository;

    @Override
    public List<Relatives> getAll() {
        return relativesRepository.findAll();
    }

    @Override
    public void saveRelatives(Relatives relatives) {
        relativesRepository.save(relatives);

    }

    @Override
    public Optional<Relatives> findRelativesById(Integer id) {
        return relativesRepository.findById(id);
    }

    @Override
    public void deleteRelativesById(Integer id) {
        relativesRepository.deleteById(id);
    }

    @Override
    public Relatives findByFullName(String fullName) {
        return relativesRepository.findByFullName(fullName);
    }

    @Override
    public List<Relatives> findByOrderByFullName() {
        return relativesRepository.findByOrderByFullName();
    }

    @Override
    public List<Relatives> findByGender(Integer number1Or0) {
        return relativesRepository.findByGender(number1Or0);
    }

    @Override
    public Relatives findByPhoneNumberIgnoreCase(String phoneNum) {
        return relativesRepository.findByPhoneNumberIgnoreCase(phoneNum);
    }

    @Override
    public List<Relatives> findByRelationshipIgnoreCase(String relationship) {
        return relativesRepository.findByRelationshipIgnoreCase(relationship);
    }

    @Override
    public List<Relatives> findByEmployeeIsNull() {
        return relativesRepository.findByEmployeeIsNull();
    }

    @Override
    public Relatives findByEmployeeEmployeeId(Integer id) {
        return relativesRepository.findByEmployeeEmployeeId(id);
    }

    @Override
    public List<Relatives> findByEmployeeFirstNameContainingIgnoreCase(String name) {
        return relativesRepository.findByEmployeeFirstNameContainingIgnoreCase(name);
    }

    @Override
    public List<Relatives> findByOrderByEmployeeFirstName() {
        return relativesRepository.findByOrderByEmployeeFirstName();
    }

    @Override
    public List<Relatives> findByEmployeeSalaryGreaterThan(Integer salary) {
        return relativesRepository.findByEmployeeSalaryGreaterThan(salary);
    }

    @Override
    public List<Relatives> findByEmployeeDepartmentDepartmentNameIgnoreCase(String departmentName) {
        return relativesRepository.findByEmployeeDepartmentDepartmentNameIgnoreCase(departmentName);
    }

    @Override
    public List<Relatives> findByEmployeeBirthdayBefore(LocalDate date) {
        return relativesRepository.findByEmployeeBirthdayBefore(date);
    }
}
