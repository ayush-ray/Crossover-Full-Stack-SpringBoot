package com.company.resourceapi.services;

import com.company.resourceapi.entities.Project;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface ProjectService {

    Optional<Project> getProject(long id);

    Project createProject(Long systemId, Project project);

    ResponseEntity<Project> updateProject(Project project, Long projectId, Long systemId);

}
