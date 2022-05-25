package com.axonactive.companySpring3.service.impl;

import com.axonactive.companySpring3.entity.Assignment;
import com.axonactive.companySpring3.repository.AssignmentRepository;
import com.axonactive.companySpring3.service.AssignmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AssignmentServiceImpl implements AssignmentService {
    private final AssignmentRepository assignmentRepository;

    @Override
    public List<Assignment> getAll() {
        return assignmentRepository.findAll();
    }

    @Override
    public void saveAssignment(Assignment assignment) {
        assignmentRepository.save(assignment);

    }

    @Override
    public Optional<Assignment> findAssignmentById(Integer id) {
        return assignmentRepository.findById(id);
    }

    @Override
    public void deleteAssignmentById(Integer id) {
        assignmentRepository.deleteById(id);

    }

    @Override
    public Assignment findByNumberOfHour(Integer numberOfHour) {
        return assignmentRepository.findByNumberOfHour(numberOfHour);
    }

    @Override
    public Assignment findByEmployeeEmployeeId(Integer id) {
        return assignmentRepository.findByEmployeeEmployeeId(id);
    }

    @Override
    public Assignment findByProjectProjectId(Integer id) {
        return assignmentRepository.findByProjectProjectId(id);
    }

    @Override
    public List<Assignment> findByNumberOfHourLessThan(Integer numberOfHour) {
        return assignmentRepository.findByNumberOfHourLessThan(numberOfHour);
    }

    @Override
    public List<Assignment> findByNumberOfHourBetween(Integer minNumberOfHour, Integer maxNumberOfHour) {
        return assignmentRepository.findByNumberOfHourBetween(minNumberOfHour, maxNumberOfHour);
    }

    @Override
    public List<Assignment> findByNumberOfHourGreaterThanOrderById(Integer numberOfHour) {
        return assignmentRepository.findByNumberOfHourGreaterThanOrderById(numberOfHour);
    }

    @Override
    public List<Assignment> findByEmployeeLastName(String name) {
        return assignmentRepository.findByEmployeeLastName(name);
    }

    @Override
    public List<Assignment> findByEmployeeDepartmentId(Integer id) {
        return assignmentRepository.findByEmployeeDepartmentId(id);
    }

    @Override
    public List<Assignment> findByEmployeeDepartmentDepartmentName(String departmentName) {
        return assignmentRepository.findByEmployeeDepartmentDepartmentName(departmentName);
    }
}
