package com.project.plans.scheduler.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.plans.scheduler.business.ScheduleProcessor;
import com.project.plans.scheduler.model.Project;
import com.project.plans.scheduler.service.ProjectPlansSchedulerService;

@RestController
public class ProjectPlansSchedulerController { 
	
	@Autowired
	private ProjectPlansSchedulerService projectPlansSchedulerService;
	
	@Autowired
	private ScheduleProcessor scheduleProcessor;

	/**
	 * API for saving project
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public Project saveProject(@RequestBody Project project) {
		
		project = scheduleProcessor.process(project);
		project = projectPlansSchedulerService.saveProject(project);
		
		return project;
	}
	
	/**
	 * API for retrieving specific project based on projectId
	 */
	@RequestMapping(value = "/projects/{projectId}")
	public Project getProject(@PathVariable long projectId) {
		Optional<Project> project = projectPlansSchedulerService.getProject(projectId);
		
		return project.get();
	}

}
