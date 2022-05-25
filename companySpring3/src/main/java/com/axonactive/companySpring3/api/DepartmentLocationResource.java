package com.axonactive.companySpring3.api;

import com.axonactive.companySpring3.entity.Department;
import com.axonactive.companySpring3.entity.DepartmentLocation;
import com.axonactive.companySpring3.service.DepartmentLocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/departmentLocation")
public class DepartmentLocationResource {
    private final DepartmentLocationService departmentLocationService;

    @GetMapping("/get")
    public List<DepartmentLocation> getAllDepartment() {
        List<DepartmentLocation> departmentLocationList = departmentLocationService.getAll();
        return departmentLocationList;
    }

    @PostMapping("/add")
    public void addDepartmentLocation(@RequestBody DepartmentLocation departmentLocation) {
        departmentLocationService.saveDepartmentLocation(departmentLocation);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteDepartment(@PathVariable(value = "id") Integer id) {
        DepartmentLocation departmentLocation = departmentLocationService.findById(id).get();
        departmentLocationService.deleteDepartmentLocationById(departmentLocation.getId());
    }
}
