package com.axonactive.companySpring3.api;

import com.axonactive.companySpring3.entity.Department;
import com.axonactive.companySpring3.entity.Project;
import com.axonactive.companySpring3.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/project")
public class ProjectResource {
    private final ProjectService projectService;

    @GetMapping("/get")
    public List<Project> getAllProject() {
        List<Project> projectList = projectService.getAll();
        return projectList;
    }

    @PostMapping("/add")
    public void addProject(@RequestBody Project project) {
        projectService.saveProject(project);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProject(@PathVariable(value = "id") Integer id) {
        Project project = projectService.findProjectById(id).get();
        projectService.deleteProjectById(project.getProjectId());

    }
}
