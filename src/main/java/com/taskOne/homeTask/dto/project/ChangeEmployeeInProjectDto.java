package com.taskOne.homeTask.dto.project;

import javax.validation.constraints.NotBlank;

public class ChangeEmployeeInProjectDto {

    @NotBlank()
    private Long projectId;

    @NotBlank()
    private Long employeeId;

    @NotBlank()
    private Long employeeIdChange;

    public ChangeEmployeeInProjectDto() {
    }

    public ChangeEmployeeInProjectDto(Long projectId,Long employeeId,Long employeeIdChange) {
        this.projectId = projectId;
        this.employeeId = employeeId;
        this.employeeIdChange = employeeIdChange;
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

    public Long getEmployeeIdChange() {
        return employeeIdChange;
    }

    public void setEmployeeIdChange(Long employeeIdChange) {
        this.employeeIdChange = employeeIdChange;
    }
}
