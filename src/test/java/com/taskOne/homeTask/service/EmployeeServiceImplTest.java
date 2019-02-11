package com.taskOne.homeTask.service;

import com.taskOne.homeTask.HomeTaskApplicationRunner;
import com.taskOne.homeTask.dto.employee.EmployeeDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Set;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;

@RunWith(SpringRunner.class)
@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "/script/data.sql")
@Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "/script/datadelete.sql")
@SpringBootTest(classes = HomeTaskApplicationRunner.class)
public class EmployeeServiceImplTest {

    private final long EMPLOYE_ID_EXIST = 1l;
    private final long EMPLOYE_ID_FALSE = 0l;
    private final long EMPLOYE_ID_DELETE_EXIST = 2L;
    private EmployeeDto emloyeeDtoToSave = new EmployeeDto("Ivan", "Ivanov", "25", "Ukraine", "2522252");
    private EmployeeDto emloyeeDtoToUpdate = new EmployeeDto(1L,"Ivan", "Ivanov", "25", "Ukraine", "2522252");

    @Autowired
    EmployeeServiceImpl employeeService;

    @Test
    public void getAllEmployeesReturnNotEmptyList() throws Exception {
        Set<EmployeeDto> list = employeeService.getAll();
        assertTrue(!list.isEmpty());
    }

    @Test
    @Sql(scripts = "/script/datadelete.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    public void getAllEmployeesReturnEmptyList() throws Exception {
        Set<EmployeeDto> list = employeeService.getAll();
        assertTrue(list.isEmpty());
    }

    @Test
    public void getEmployeeByIdReturnObjectWithNullIdReturnTrue() throws Exception {
        assertNull(employeeService.getById(EMPLOYE_ID_FALSE).getEmployeeId());
    }

    @Test
    public void getEmployeeByIdReturnTrue() throws Exception {
        assertNotNull(employeeService.getById(EMPLOYE_ID_EXIST).getEmployeeId());
    }

    @Test
    @Sql(scripts = "/script/datadelete.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    public void saveEmployeeSaveSuccesfullReturnTrue() throws Exception {
        EmployeeDto reseived = employeeService.create(emloyeeDtoToSave);
        assertAll("emloyeeDtoToSave",
                () -> assertEquals(reseived.getName(), emloyeeDtoToSave.getName()),
                () -> assertEquals(reseived.getSurname(), emloyeeDtoToSave.getSurname()),
                () -> assertEquals(reseived.getAge(), emloyeeDtoToSave.getAge()),
                () -> assertEquals(reseived.getCityzen(), emloyeeDtoToSave.getCityzen()),
                () -> assertEquals(reseived.getPhone(), emloyeeDtoToSave.getPhone()));
        assertNotNull(reseived.getEmployeeId());
    }

    @Test
    public void deleteEmployeeSuccesfullReturnTrue() throws Exception {
        employeeService.delete(EMPLOYE_ID_DELETE_EXIST);
        EmployeeDto result = employeeService.getById(EMPLOYE_ID_DELETE_EXIST);
        assertNull(result.getEmployeeId());
    }

    @Test
    public void updateEmployeeSuccesfullReturnTrue() throws Exception {
        assertTrue(employeeService.update(emloyeeDtoToUpdate));
    }
}

