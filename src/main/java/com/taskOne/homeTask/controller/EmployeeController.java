package com.taskOne.homeTask.controller;

import com.taskOne.homeTask.dto.ResponseBody;
import com.taskOne.homeTask.dto.employee.EmployeeDto;
import com.taskOne.homeTask.message.Message;
import com.taskOne.homeTask.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.OK;

import static org.springframework.http.ResponseEntity.status;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeServiceImpl employeeService;

    @Autowired
    public EmployeeController(EmployeeServiceImpl employeesService) {
        this.employeeService = employeesService;
    }

    @GetMapping()
    public ResponseEntity<?> getAllEmployees() {
        return status(OK).body(employeeService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> employeeById(@PathVariable final Long id) {
        if (employeeService.getById(id).getEmployeeId() != null) {
            return status(OK).body(employeeService.getById(id));
        }
        return status(BAD_REQUEST).body(new ResponseBody(false, Message.FAILED_GETBYID_EMPLOYEE.getDescription()));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployeeById(@PathVariable final Long id) {
        if (employeeService.delete(id)) {
            return status(OK).body(new ResponseBody(true, Message.SUCCESS_DELETE_EMPLOYEE.getDescription()));
        }
        return status(BAD_REQUEST).body(new ResponseBody(false, Message.FAILED_DELETE_EMPLOYEE.getDescription()));
    }

    @PostMapping()
    public ResponseEntity<?> saveEmployee(@Valid @RequestBody final EmployeeDto saveRequest,
                                          final HttpServletResponse response) {
        return status(OK).body(employeeService.create(saveRequest));
    }

    @PutMapping()
    public ResponseEntity<?> updateEmployee(@RequestBody final EmployeeDto updateRequest) {
        employeeService.update(updateRequest);
        return status(OK).body(new ResponseBody(true, Message.SUCCESS_UPDATE_EMPLOYEE.getDescription()));
    }
}
