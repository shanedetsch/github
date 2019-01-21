package com.pi.spring.ppmtool.services;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.pi.spring.ppmtool.domain.*;
import com.pi.spring.ppmtool.exceptions.*;
import com.pi.spring.ppmtool.repositories.*;

@Service
public class ProjectService
{
	@Autowired
	private ProjectRepository projectRepository;
	
	
	public void deleteProjectByIdentifier(String projectId)  {
		Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase());
		if(null == project) {
			throw new ProjectIdException("Cannot delete project with ID " + projectId + ". This project does not exists.");
		}
		
		projectRepository.delete(project);
	}
	
	public Iterable<Project> findAllProjects() {
		return projectRepository.findAll();
	}
	
	public Project saveOrUpdateProject(Project project) {
		try {
			project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
			return projectRepository.save(project);
		} catch(Exception e) {
			throw new ProjectIdException("Project Id " + project.getProjectIdentifier().toUpperCase() + " already exists.");
		}
	}
	
	public Project findProjectByIdentifier(String projectIdentifier) {
		Project project =  projectRepository.findByProjectIdentifier(projectIdentifier.toUpperCase());
		if(null == project) {
			throw new ProjectIdException("Project Id " + projectIdentifier.toUpperCase() + " does not exists.");
		}
		return project;
	}
}
