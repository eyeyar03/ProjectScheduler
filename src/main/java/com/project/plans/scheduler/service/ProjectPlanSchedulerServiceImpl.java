package com.project.plans.scheduler.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.plans.scheduler.model.Project;
import com.project.plans.scheduler.repository.ProjectRepository;

@Service
public class ProjectPlanSchedulerServiceImpl implements ProjectPlansSchedulerService {
	
	@Autowired
	private ProjectRepository projectRepository;

	@Override
	public Project saveProject(Project project) {
		return projectRepository.save(project);
	}

	@Override
	public Optional<Project> getProject(long projectId) {
		return projectRepository.findById(projectId);
	}

}
