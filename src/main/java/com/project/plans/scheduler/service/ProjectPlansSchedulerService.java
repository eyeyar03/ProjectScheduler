package com.project.plans.scheduler.service;

import java.util.Optional;

import com.project.plans.scheduler.model.Project;

public interface ProjectPlansSchedulerService {
	
	Project saveProject(Project project);
	
	Optional<Project> getProject(long projectId);
}
