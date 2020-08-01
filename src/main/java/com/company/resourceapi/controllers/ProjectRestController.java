package com.company.resourceapi.controllers;

import com.company.resourceapi.entities.Project;
import com.company.resourceapi.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping(ProjectRestController.ENDPOINT)
public class ProjectRestController {

	public static final String ENDPOINT = "/api/v2/projects";
	public static final String ENDPOINT_ID = "/{id}";
	public static final String PATH_VARIABLE_ID = "id";
	public static final String SYSTEM_ID = "/sdlc-systems/{system_id}";
	public static final String PATH_VARIABLE_SYSTEM_ID = "system_id";


	@Autowired
	private ProjectService projectService;

	@GetMapping(ENDPOINT_ID)
	public Optional<Project> getProject(
			@PathVariable(PATH_VARIABLE_ID)
			final long projectId
	) {
		return projectService.getProject(projectId);
	}

	@PostMapping(ENDPOINT_ID)
	public Project createProject(@PathVariable(value = "id") Long systemId, @Valid @RequestBody Project project) {
		return projectService.createProject(systemId, project);
	}

	@PutMapping(ENDPOINT_ID+SYSTEM_ID)
	public ResponseEntity<Project> updateProject(@PathVariable(PATH_VARIABLE_ID) Long projectId,
												 @PathVariable(PATH_VARIABLE_SYSTEM_ID) Long systemId,
												 @Valid @RequestBody Project project){
		return projectService.updateProject(project, projectId, systemId);
	}
}