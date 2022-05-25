package com.axonactive.companySpring3.service.impl;

import com.axonactive.companySpring3.entity.Department;
import com.axonactive.companySpring3.repository.DepartmentRepository;
import com.axonactive.companySpring3.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;

    @Override
    public List<Department> getAll() {
        return departmentRepository.findAll();
    }

    @Override
    public void saveDepartment(Department department) {
        departmentRepository.save(department);

    }

    @Override
    public Optional<Department> findDepartmentById(Integer id) {
        return departmentRepository.findById(id);
    }

    @Override
    public void deleteDepartmentById(Integer id) {
        departmentRepository.deleteById(id);

    }
}
