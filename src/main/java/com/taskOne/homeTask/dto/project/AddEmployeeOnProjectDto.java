package com.taskOne.homeTask.dto.project;

import javax.validation.constraints.NotBlank;

public class AddEmployeeOnProjectDto {

    @NotBlank()
    private Long projectId;

    @NotBlank()
    private Long employeeId;

    public AddEmployeeOnProjectDto() {
    }

    public AddEmployeeOnProjectDto(Long projectId, Long employeeId) {
        this.projectId = projectId;
        this.employeeId = employeeId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public String toString() {
        return "AddEmployeeOnProjectDto{" +
                "projectId=" + projectId +
                ", employeeId=" + employeeId +
                '}';
    }
}
