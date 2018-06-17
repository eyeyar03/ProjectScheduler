package com.project.plans.scheduler.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Task {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long taskId;
	
	private String name;
	
	private int duration;
	
	private Date startDate;
	
	private Date endDate;
	
	// this is only used for UI
	private String guiId;
	
	private String dependsOn;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getTaskId() {
		return taskId;
	}

	public void setTaskId(long taskId) {
		this.taskId = taskId;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getGuiId() {
		return guiId;
	}

	public void setGuiId(String guiId) {
		this.guiId = guiId;
	}

	public String getDependsOn() {
		return dependsOn;
	}

	public void setDependsOn(String dependsOn) {
		this.dependsOn = dependsOn;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		builder.append("Task Name: " + name + "\n");
		builder.append("Task ID: " + taskId + "\n");
		builder.append("Task Duration: " + duration + "\n");
		builder.append("Start Date: " + startDate + "\n");
		builder.append("End Date: " + endDate + "\n");
		builder.append("dependsOn: " + dependsOn + "\n");
		
		return builder.toString();
	}
	
}
