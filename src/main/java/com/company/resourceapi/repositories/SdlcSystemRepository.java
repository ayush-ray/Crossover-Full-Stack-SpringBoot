package com.company.resourceapi.repositories;

import com.company.resourceapi.entities.SdlcSystem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SdlcSystemRepository extends CrudRepository<SdlcSystem, Long> {

}
