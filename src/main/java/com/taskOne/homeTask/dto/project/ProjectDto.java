package com.taskOne.homeTask.dto.project;

import com.taskOne.homeTask.dto.employee.EmployeeDto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

public class ProjectDto {

    private Long projectId;

    @NotBlank()
    @Size(min = 2, max = 20)
    private String name;

    @NotBlank()
    @Size(min = 6, max = 20)
    private String startDate;

    @NotBlank()
    @Size(min = 6, max = 20)
    private String endDate;

    @NotBlank()
    @Size(min = 2, max = 200)
    private String description;

    private Set<EmployeeDto> employeeDtOInProject = new HashSet<>();

    public ProjectDto() {
    }
    public ProjectDto(String name, String startDate, String endDate, String description) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
    }

    public ProjectDto(Long projectId, String name, String startDate, String endDate, String description) {
        this.projectId = projectId;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
    }

    public ProjectDto(Long projectId, String name, String startDate, String endDate, String description, Set<EmployeeDto> employeeDtOInProject ) {
        this.projectId = projectId;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
        this.employeeDtOInProject = employeeDtOInProject;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<EmployeeDto> getEmployeeDtOInProject() {
        return employeeDtOInProject;
    }

    public void setEmployeeDtOInProject(Set<EmployeeDto> employeeDtOInProject) {
        this.employeeDtOInProject = employeeDtOInProject;
    }

    @Override
    public String toString() {
        return "ProjectDto{" +
                "projectId=" + projectId +
                ", name='" + name + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
