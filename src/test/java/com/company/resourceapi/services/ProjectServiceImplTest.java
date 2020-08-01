package com.company.resourceapi.services;

import com.company.resourceapi.entities.Project;
import com.company.resourceapi.repositories.ProjectRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class ProjectServiceImplTest {

    @Autowired
    private ProjectService service;

    @MockBean
    ProjectRepository repository;

    @TestConfiguration
    static class ProjectServiceImplTestConfiguration{

        @MockBean
        ProjectRepository inner_repository;

        @Bean
        public ProjectService getService(){
            return new ProjectServiceImpl(inner_repository);
        }
    }

    private Optional<Project> project;


    @Before
    public void setUp() throws Exception {
        project = repository.findById((long)2);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getProject() {
        Optional<Project> result = service.getProject((long)2);
        Assert.assertEquals("GET matched", project, result);
    }

    @Test
    public void createProject() {
        if(project.isPresent()){
            Project project_post = repository.save(project.get());
            Project result = service.createProject(project_post.getId(), project_post);
            Assert.assertEquals("POST matched", project_post, result);
        }
    }

    @Test
    public void updateProject() {
    }
}