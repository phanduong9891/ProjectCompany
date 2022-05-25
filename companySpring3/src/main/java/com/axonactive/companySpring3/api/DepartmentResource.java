package com.axonactive.companySpring3.api;

import com.axonactive.companySpring3.entity.Department;
import com.axonactive.companySpring3.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/departments")
public class DepartmentResource {
    private final DepartmentService departmentService;

    @GetMapping("/get")
    public List<Department> getAllDepartment() {
        List<Department> departmentList = departmentService.getAll();
        return departmentList;
    }

    @PostMapping("/add")
    public void addDepartment(@RequestBody Department department) {
        departmentService.saveDepartment(department);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteDepartment(@PathVariable(value = "id")Integer  id) {
        Department department = departmentService.findDepartmentById(id).get();

        departmentService.deleteDepartmentById(department.getId());
    }
}
