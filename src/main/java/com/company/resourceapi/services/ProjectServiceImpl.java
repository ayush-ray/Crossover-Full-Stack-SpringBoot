package com.company.resourceapi.services;

import com.company.resourceapi.entities.Project;
import com.company.resourceapi.repositories.ProjectRepository;
import com.company.resourceapi.repositories.SdlcSystemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;


import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private final ProjectRepository projectRepository;

	@Autowired
	private SdlcSystemRepository sdlcSystemRepository;

	public ProjectServiceImpl(ProjectRepository projectRepository) {
		this.projectRepository = projectRepository;
	}

	public Optional<Project> getProject(long id) {
		System.out.println("lalala");
		System.out.println(projectRepository.findById(id));
		return projectRepository.findById(id);
	}

	public Project createProject(Long systemId, Project project) {
		sdlcSystemRepository.findById(systemId).ifPresent(project::setSdlcSystem);
		return projectRepository.save(project);
	}

	public ResponseEntity<Project> updateProject(Project projectDetails, Long projectId, Long systemId){
		return projectRepository.findBySdlcSystemIdAndId(systemId, projectId)
				.map(project -> {
					project.setExternalId(projectDetails.getExternalId());
					project.setName(projectDetails.getName());
					project.setSdlcSystem(projectDetails.getSdlcSystem());
					final Project updatedProject = projectRepository.save(project);
					return ResponseEntity.ok(updatedProject);
				})
				.orElseGet(() -> ResponseEntity.noContent().build());
	}
}
