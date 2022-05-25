package com.axonactive.companySpring3.api;

import com.axonactive.companySpring3.entity.Assignment;
import com.axonactive.companySpring3.entity.Relatives;
import com.axonactive.companySpring3.service.AssignmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/assignment")
public class AssignmentResource {
    private final AssignmentService assignmentService;

    @GetMapping("/get")
    public List<Assignment> getAllAssignment(){
        List<Assignment> assignmentList = assignmentService.getAll();
        return assignmentList;
    }
    @PostMapping("/add")
    public void addAssignment(@RequestBody Assignment assignment){
        assignmentService.saveAssignment(assignment);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAssignment(@PathVariable(value = "id") Integer id) {
        Assignment assignment = assignmentService.findAssignmentById(id).get();
        assignmentService.deleteAssignmentById(assignment.getId());

    }
}
