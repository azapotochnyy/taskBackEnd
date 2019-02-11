package com.taskOne.homeTask.service;

import com.taskOne.homeTask.dto.project.AddEmployeeOnProjectDto;
import com.taskOne.homeTask.dto.project.ChangeEmployeeInProjectDto;

public interface CommonService {

    /**
     * Method add Eployee to the Object.
     *
     * @param addEmployeeOnProjectDto - consists of two idis (projectId and employeeId)
     * @return true if the employee is added successfully. Otherwise false;
     */
    boolean addEmployeeOnTheProject(AddEmployeeOnProjectDto addEmployeeOnProjectDto);

    /**
     * Method delete Eployee from the Object.
     *
     * @param addEmployeeOnProjectDto - consists of two idis (projectId and employeeId)
     * @return true if the employee is deleted from the object successfully. Otherwise false;
     */
    boolean deleteEmployeeFromTheProject(AddEmployeeOnProjectDto addEmployeeOnProjectDto);


    /**
     * Method change Eployee on the Object.
     *
     * @param addEmployeeOnProjectDto - consists of three idis (projectId, employeeId, employeeIdChange)
     * @return true if the employee is changed on the object successfully. Otherwise false;
     */
    boolean ChangeEmployeeOnTheProject(ChangeEmployeeInProjectDto addEmployeeOnProjectDto);




}
