package com.taskOne.homeTask.controller;

import com.taskOne.homeTask.dto.ResponseBody;
import com.taskOne.homeTask.dto.project.ChangeEmployeeInProjectDto;
import com.taskOne.homeTask.dto.project.ProjectDto;
import com.taskOne.homeTask.dto.project.AddEmployeeOnProjectDto;
import com.taskOne.homeTask.message.Message;
import com.taskOne.homeTask.service.CommonServiceImpl;
import com.taskOne.homeTask.service.ProjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.ResponseEntity.status;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/projects")
public class ProjectController {

    private ProjectServiceImpl projectService;

    private CommonServiceImpl commonService;

    @Autowired
    public ProjectController(ProjectServiceImpl projectService, CommonServiceImpl addDeleteEmployeOnProject) {
        this.projectService = projectService;
        this.commonService = addDeleteEmployeOnProject;
    }

    @GetMapping()
    public ResponseEntity<?> getAllProjects() {
        return status(OK).body(projectService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> projectById(@PathVariable final Long id) {
        if (projectService.getById(id).getProjectId()!= null) {
            return status(OK).body(projectService.getById(id));
        }
        return status(BAD_REQUEST).body(new ResponseBody(false, Message.FAILED_GETBYID_PROJECT.getDescription()));
    }

    @GetMapping("/{id}/list")
    public ResponseEntity<?> listOfEmployeesOnProjectById(@PathVariable final Long id) {
        return status(OK).body(projectService.listOfEmployeesOnProjectById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProjectById(@PathVariable final Long id) {
        if (projectService.delete(id)) {
            return status(OK).body(new ResponseBody(true, Message.SUCCESS_DELETE_PROJECT.getDescription()));
        }
        return status(BAD_REQUEST).body(new ResponseBody(false, Message.FAILED_DELETE_PROJECT.getDescription()));
    }

    @DeleteMapping("/list")
    public ResponseEntity<?> deleteEmployeeFromTheProject(@RequestBody final AddEmployeeOnProjectDto deleteEmployeeFromTheProjectDto) {
        if (commonService.deleteEmployeeFromTheProject(deleteEmployeeFromTheProjectDto)) {
            return status(OK).body(new ResponseBody(true, Message.SUCCESS_DELETE_EMPLOYE_FROM_PROJECT.getDescription()));
        }
        return status(BAD_REQUEST).body(new ResponseBody(false, Message.FAILED_DELETE_EMPLOYE_FROM_PROJECT.getDescription()));
    }

    @PostMapping()
    public ResponseEntity<?> saveProject(@Valid @RequestBody final ProjectDto saveRequest,
                                         final HttpServletResponse response) {
        return status(OK).body(projectService.create(saveRequest));
    }

    @PutMapping()
    public ResponseEntity<?> updateProject(@RequestBody final ProjectDto updateRequest) {
        projectService.update(updateRequest);
        return status(OK).body(new ResponseBody(true, Message.SUCCESS_UPDATE_PROJECT.getDescription()));
    }

    @PutMapping("/list")
    public ResponseEntity<?> addEmployeeOnProject(@RequestBody final AddEmployeeOnProjectDto addEmployeeOnProjectDto) {
        if (commonService.addEmployeeOnTheProject(addEmployeeOnProjectDto)) {
            return status(OK).body(new ResponseBody(true, Message.SUCCESS_ADD_EMPLOYE_ON_PROJECT.getDescription()));
        }
        return status(BAD_REQUEST).body(new ResponseBody(false, Message.FAILED_ADD_EMPLOYE_ON_PROJECT.getDescription()));
    }

    @PutMapping("/list/change")
    public ResponseEntity<?> changeEmployeeOnProject(@RequestBody final ChangeEmployeeInProjectDto changeEmployeeInProjectDto) {
        if (commonService.ChangeEmployeeOnTheProject(changeEmployeeInProjectDto)) {
            return status(OK).body(new ResponseBody(true, Message.SUCCESS_CHANGE_EMPLOYE_ON_PROJECT.getDescription()));
        }
        return status(BAD_REQUEST).body(new ResponseBody(false, Message.FAILED_CHANGE_EMPLOYE_ON_PROJECT.getDescription()));
    }
}


