package com.axonactive.companySpring3.service.impl;

import com.axonactive.companySpring3.entity.Project;
import com.axonactive.companySpring3.repository.ProjectRepository;
import com.axonactive.companySpring3.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;


    @Override
    public List<Project> getAll() {
        return projectRepository.findAll();
    }

    @Override
    public void saveProject(Project project) {
        projectRepository.save(project);

    }

    @Override
    public Optional<Project> findProjectById(Integer id) {
        return projectRepository.findById(id);
    }

    @Override
    public void deleteProjectById(Integer id) {
        projectRepository.deleteById(id);

    }

    @Override
    public Project findByProjectName(String name) {
        return projectRepository.findByProjectName(name);
    }

    @Override
    public List<Project> findProjectByDepartmentDepartmentName(String name) {
        return projectRepository.findProjectByDepartmentDepartmentName(name);
    }

    @Override
    public Project findByProjectNameIgnoreCase(String name) {
        return projectRepository.findByProjectNameIgnoreCase(name);
    }

    @Override
    public List<Project> findByArea(String area) {
        return projectRepository.findByArea(area);
    }

    @Override
    public List<Project> findByAreaOrderByProjectName(String area) {
        return projectRepository.findByAreaOrderByProjectName(area);
    }

    @Override
    public List<Project> findByDepartmentStartDate(LocalDate date) {
        return projectRepository.findByDepartmentStartDate(date);
    }

    @Override
    public List<Project> findByProjectNameContaining(String name) {
        return projectRepository.findByProjectNameContaining(name);
    }

    @Override
    public List<Project> findByDepartmentDepartmentNameOrderByProjectName(String departmentName) {
        return projectRepository.findByDepartmentDepartmentNameOrderByProjectName(departmentName);
    }

    @Override
    public List<Project> findByDepartmentDepartmentNameNot(String departmentName) {
        return projectRepository.findByDepartmentDepartmentNameNot(departmentName);
    }
}
