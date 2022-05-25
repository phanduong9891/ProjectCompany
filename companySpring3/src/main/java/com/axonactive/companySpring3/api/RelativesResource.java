package com.axonactive.companySpring3.api;

import com.axonactive.companySpring3.entity.Department;
import com.axonactive.companySpring3.entity.Relatives;
import com.axonactive.companySpring3.service.DepartmentService;
import com.axonactive.companySpring3.service.RelativesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/relatives")
public class RelativesResource {
    private final RelativesService relativesService;

    @GetMapping("/get")
    public List<Relatives> getAllRelatives() {
        List<Relatives> relativesList = relativesService.getAll();
        return relativesList;
    }

    @PostMapping("/add")
    public void addRelatives(@RequestBody Relatives relatives) {
        relativesService.saveRelatives(relatives);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteRelatives(@PathVariable(value = "id") Integer id) {
        Relatives relatives = relativesService.findRelativesById(id).get();

        relativesService.deleteRelativesById(relatives.getId());
    }
}
