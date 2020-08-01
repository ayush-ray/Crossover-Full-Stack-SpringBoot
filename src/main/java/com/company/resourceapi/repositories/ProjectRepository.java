package com.company.resourceapi.repositories;

import com.company.resourceapi.entities.Project;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {

    Optional<Project> findBySdlcSystemIdAndId(long sdlcSystemId, long projectId);
}
