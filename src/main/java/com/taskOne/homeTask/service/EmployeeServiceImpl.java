package com.taskOne.homeTask.service;

import com.taskOne.homeTask.dto.employee.EmployeeDto;
import com.taskOne.homeTask.entity.Employee;
import com.taskOne.homeTask.repository.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeProjectService<EmployeeDto> {

    private EmployeesRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeesRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeDto create(EmployeeDto emloyeeDto) {
        Employee employee = new Employee(
                emloyeeDto.getName(),
                emloyeeDto.getSurname(),
                emloyeeDto.getAge(),
                emloyeeDto.getCityzen(),
                emloyeeDto.getPhone());
        Employee employeesaved = employeeRepository.save(employee);
        return new EmployeeDto(
                employeesaved.getEmployeeId(),
                employeesaved.getName(),
                employeesaved.getSurname(),
                employeesaved.getAge(),
                employeesaved.getCityzen(),
                employeesaved.getPhone());
    }

    @Override
    public EmployeeDto getById(Long id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        Employee employee = optionalEmployee.isPresent() ? optionalEmployee.get() : new Employee();
        return new EmployeeDto(
                employee.getEmployeeId(),
                employee.getName(),
                employee.getSurname(),
                employee.getAge(),
                employee.getCityzen(),
                employee.getPhone());
    }

    @Override
    @Transactional
    public boolean delete(Long id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        Employee employee = optionalEmployee.isPresent() ? optionalEmployee.get() : new Employee();
        if (employee.getEmployeeId() != null) {
            employeeRepository.delete(employee);
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public boolean update(EmployeeDto entity) {
        final Employee employee = employeeRepository.findById(entity.getEmployeeId()).get();
        employee.setName(entity.getName());
        employee.setSurname(entity.getSurname());
        employee.setAge(entity.getAge());
        employee.setCityzen(entity.getCityzen());
        employee.setPhone(entity.getPhone());
        employeeRepository.save(employee);
        return true;
    }

    @Override
    public Set<EmployeeDto> getAll() {
        List<Employee> allEmployees = employeeRepository.findAll();
        return allEmployees.stream().map(employee -> new EmployeeDto(employee.getEmployeeId(),
                employee.getName(),
                employee.getSurname(),
                employee.getAge(),
                employee.getCityzen(),
                employee.getPhone())).collect(Collectors.toSet());
    }
}
