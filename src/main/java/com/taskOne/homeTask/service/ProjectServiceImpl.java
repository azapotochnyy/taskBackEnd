package com.taskOne.homeTask.service;

import com.taskOne.homeTask.dto.employee.EmployeeDto;
import com.taskOne.homeTask.dto.project.ProjectDto;
import com.taskOne.homeTask.entity.Project;
import com.taskOne.homeTask.repository.ProjectsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements EmployeeProjectService<ProjectDto> {

    private ProjectsRepository projectsRepository;

    @Autowired
    public ProjectServiceImpl(ProjectsRepository projectsRepository) {
        this.projectsRepository = projectsRepository;
    }

    @Override
    public ProjectDto create(ProjectDto projectDto) {
        Project project = new Project(
                projectDto.getName(),
                projectDto.getStartDate(),
                projectDto.getEndDate(),
                projectDto.getDescription());
        Project projecrtSaved = projectsRepository.save(project);
        return new ProjectDto(
                projecrtSaved.getProjectId(),
                projecrtSaved.getName(),
                projecrtSaved.getStartDate(),
                projecrtSaved.getEndDate(),
                projecrtSaved.getDescription());
    }

    @Override
    public ProjectDto getById(Long projectId) {
        Optional<Project> optionalProject = projectsRepository.findById(projectId);
        Project project = optionalProject.isPresent() ? optionalProject.get() : new Project();
        return new ProjectDto(
                project.getProjectId(),
                project.getName(),
                project.getStartDate(),
                project.getEndDate(),
                project.getDescription());
    }

    public Set<EmployeeDto> listOfEmployeesOnProjectById(Long projectId) {
        Optional<Project> projectOptional = projectsRepository.findById(projectId);
        Project project = projectOptional.get();
        return project.getEmployeeInProject().stream().map(employee -> new EmployeeDto(
                employee.getEmployeeId(),
                employee.getName(),
                employee.getSurname(),
                employee.getAge(),
                employee.getCityzen(),
                employee.getPhone())).collect(Collectors.toSet());
    }

    @Override
    @Transactional
    public boolean delete(Long projectId) {
        Optional<Project> optionalProject = projectsRepository.findById(projectId);
        Project project = optionalProject.isPresent() ? optionalProject.get() : new Project();
        if (project.getProjectId() != null) {
            projectsRepository.delete(project);
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public boolean update(ProjectDto projectDto) {
        final Project project = projectsRepository.findById(projectDto.getProjectId()).get();
        project.setName(projectDto.getName());
        project.setStartDate(projectDto.getName());
        project.setEndDate(projectDto.getName());
        project.setDescription(projectDto.getName());
        projectsRepository.save(project);
        return true;
    }

    @Override
    public Set<ProjectDto> getAll() {
        List<Project> allProjects = projectsRepository.findAll();
        return allProjects.stream().map(project -> new ProjectDto(project.getProjectId(),
                project.getName(),
                project.getStartDate(),
                project.getEndDate(),
                project.getDescription())).collect(Collectors.toSet());
    }

}
