package com.project.plans.scheduler.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.plans.scheduler.model.Project;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {

}
