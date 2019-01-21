package com.pi.spring.ppmtool.web;

import java.util.*;

import javax.validation.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.validation.*;
import org.springframework.web.bind.annotation.*;

import com.pi.spring.ppmtool.domain.*;
import com.pi.spring.ppmtool.services.*;

@RestController
@RequestMapping("/api/project")
@CrossOrigin
public class ProjectController
{
	@Autowired
	private ProjectService projectService; 
	
	@Autowired
	private MapValidationErrorService mapValidationErrorService;
	
	@DeleteMapping("/{projectId}")
	public ResponseEntity<?> deleteProject(@PathVariable String projectId) {
		projectService.deleteProjectByIdentifier(projectId);
		return new ResponseEntity<String>("Project with ID: " + projectId +" was deleted.", HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public Iterable<Project> getAllProjects() {
		return projectService.findAllProjects();
	}
	
	@GetMapping("/{projectId}")
	public ResponseEntity<?> getProjectById(@PathVariable String projectId) {
		Project project = projectService.findProjectByIdentifier(projectId);
		return new ResponseEntity<Project>(project, HttpStatus.OK);
	}
	
	/**
	 * Also can update but you have to add the id to the response. 
	 * @param project
	 * @param result
	 * @return
	 */
	@PostMapping("")
	public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project, BindingResult result ) {
		
		ResponseEntity<Map<String, String>> errorMap = mapValidationErrorService.mapValidationService(result);
		
		if(null != errorMap) {
			return errorMap;
		} 
		
		projectService.saveOrUpdateProject(project);
		return new ResponseEntity<Project>(project, HttpStatus.CREATED);
		

	}

}
