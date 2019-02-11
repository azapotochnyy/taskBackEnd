package com.taskOne.homeTask.service;

import com.taskOne.homeTask.HomeTaskApplicationRunner;
import com.taskOne.homeTask.dto.project.ProjectDto;
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
public class ProjectServiceImplTest {
    private final long PROJECT_ID_EXIST = 1l;
    private final long PROJECT_ID_FALSE = 0l;
    private final long PROJECT_ID_DELETE_EXIST = 2L;
    private ProjectDto projectDtoToSave = new ProjectDto("Project One", "22152019", "25152019", "Description");
    private ProjectDto projectDtoToUpdate = new ProjectDto(1L,"Project One Update", "22152019", "25152019", "Description");

    @Autowired
    ProjectServiceImpl projectService;

    @Test
    public void getAllProjectsReturnNotEmptyList() throws Exception {
        Set<ProjectDto> list = projectService.getAll();
        assertTrue(!list.isEmpty());
    }

    @Test
    @Sql(scripts = "/script/datadelete.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    public void getAllProjectsReturnEmptyList() throws Exception {
        Set<ProjectDto> list = projectService.getAll();
        assertTrue(list.isEmpty());
    }

    @Test
    public void getProjectByIdReturnObjectWithNullIdReturnTrue() throws Exception {
        assertNull(projectService.getById(PROJECT_ID_FALSE).getProjectId());
    }

    @Test
    public void getProjectByIdReturnTrue() throws Exception {
        assertNotNull(projectService.getById(PROJECT_ID_EXIST).getProjectId());
    }

    @Test
    @Sql(scripts = "/script/datadelete.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    public void saveProjectSaveSuccesfullReturnTrue() throws Exception {
        ProjectDto reseived = projectService.create(projectDtoToSave);
        assertAll("projectDtoToSave",
                () -> assertEquals(reseived.getName(), projectDtoToSave.getName()),
                () -> assertEquals(reseived.getStartDate(), projectDtoToSave.getStartDate()),
                () -> assertEquals(reseived.getEndDate(), projectDtoToSave.getEndDate()),
                () -> assertEquals(reseived.getDescription(), projectDtoToSave.getDescription()));
        assertNotNull(reseived.getProjectId());
    }

    @Test
    public void deleteProjectSuccesfullReturnTrue() throws Exception {
        projectService.delete(PROJECT_ID_DELETE_EXIST);
        ProjectDto result = projectService.getById(PROJECT_ID_DELETE_EXIST);
        assertNull(result.getProjectId());
    }

    @Test
    public void updateProjectSuccesfullReturnTrue() throws Exception {
        assertTrue(projectService.update(projectDtoToUpdate));
    }
}