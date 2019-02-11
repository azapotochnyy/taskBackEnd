package com.taskOne.homeTask.service;

import com.taskOne.homeTask.dto.project.AddEmployeeOnProjectDto;
import com.taskOne.homeTask.dto.project.ChangeEmployeeInProjectDto;
import com.taskOne.homeTask.entity.Employee;
import com.taskOne.homeTask.entity.Project;
import com.taskOne.homeTask.repository.EmployeesRepository;
import com.taskOne.homeTask.repository.ProjectsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CommonServiceImpl implements CommonService {

    private EmployeesRepository employeeRepository;
    private ProjectsRepository projectsRepository;

    @Autowired
    public CommonServiceImpl(EmployeesRepository employeeRepository, ProjectsRepository projectsRepository) {
        this.employeeRepository = employeeRepository;
        this.projectsRepository = projectsRepository;
    }

    @Override
    @Transactional
    public boolean addEmployeeOnTheProject(AddEmployeeOnProjectDto addEmployeeOnProjectDto) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(addEmployeeOnProjectDto.getEmployeeId());
        Employee employee = optionalEmployee.isPresent() ? optionalEmployee.get() : new Employee();
        Optional<Project> optionalProject = projectsRepository.findById(addEmployeeOnProjectDto.getProjectId());
        Project project = optionalProject.isPresent() ? optionalProject.get() : new Project();
        if (employee.getEmployeeId() != null && project.getProjectId() != null) {
            employee.getProjects().add(project);
            project.getEmployeeInProject().add(employee);
            employeeRepository.save(employee);
            projectsRepository.save(project);
            return true;
        }
        return false;
    }


    @Override
    @Transactional
    public boolean deleteEmployeeFromTheProject(AddEmployeeOnProjectDto addEmployeeOnProjectDto) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(addEmployeeOnProjectDto.getEmployeeId());
        Employee employee = optionalEmployee.isPresent() ? optionalEmployee.get() : new Employee();
        Optional<Project> optionalProject = projectsRepository.findById(addEmployeeOnProjectDto.getProjectId());
        Project project = optionalProject.isPresent() ? optionalProject.get() : new Project();
        if (employee.getEmployeeId() != null && project.getProjectId() != null) {
            employee.getProjects().remove(project);
            project.getEmployeeInProject().remove(employee);
            employeeRepository.save(employee);
            projectsRepository.save(project);
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public boolean ChangeEmployeeOnTheProject(ChangeEmployeeInProjectDto changeEmployeeOnProjectDto) {
        Optional<Employee> optionalEmployeeChange = employeeRepository.findById(changeEmployeeOnProjectDto.getEmployeeIdChange());
        Employee employeeChange = optionalEmployeeChange.isPresent() ? optionalEmployeeChange.get() : new Employee();
        Optional<Employee> optionalEmployeeAdd = employeeRepository.findById(changeEmployeeOnProjectDto.getEmployeeId());
        Employee employeeAdd = optionalEmployeeAdd.isPresent() ? optionalEmployeeAdd.get() : new Employee();
        Optional<Project> optionalProject = projectsRepository.findById(changeEmployeeOnProjectDto.getProjectId());
        Project project = optionalProject.isPresent() ? optionalProject.get() : new Project();
        if (employeeChange.getEmployeeId() != null && employeeAdd.getEmployeeId() != null && project.getProjectId() != null) {
            employeeChange.getProjects().remove(project);
            employeeAdd.getProjects().add(project);
            project.getEmployeeInProject().remove(employeeChange);
            project.getEmployeeInProject().add(employeeAdd);
            employeeRepository.save(employeeChange);
            employeeRepository.save(employeeAdd);
            projectsRepository.save(project);
            return true;
        }
        return false;
    }

}







