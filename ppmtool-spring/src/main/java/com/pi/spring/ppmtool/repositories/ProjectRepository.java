package com.pi.spring.ppmtool.repositories;

import org.springframework.data.repository.*;
import org.springframework.stereotype.Repository;

import com.pi.spring.ppmtool.domain.*;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long>
{

	Project findByProjectIdentifier(String projectIdentifier);
	
	@Override
	Iterable<Project> findAll();
}
