package com.project.plans.scheduler.business;

import java.util.ArrayList;
import java.util.List;

public class TaskNode {
	
	private String data;
	
	private List<TaskNode> upTaskNodes;
	
	private List<TaskNode> downTaskNodes;
	
	public TaskNode(String data) {
		this.data = data;
		this.downTaskNodes = new ArrayList<>();
		this.upTaskNodes = new ArrayList<>();
	}
	
	public void addUpTaskNode(TaskNode upTaskNode) {
		this.upTaskNodes.add(upTaskNode);
	}
	
	public void addDownTaskNode(TaskNode downTaskNode) {
		this.downTaskNodes.add(downTaskNode);
	}
	
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}


	public List<TaskNode> geUpTaskNodes() {
		return upTaskNodes;
	}

	public void setUpTaskNodes(List<TaskNode> upTaskNodes) {
		this.upTaskNodes = upTaskNodes;
	}
	
	public List<TaskNode> getDownTaskNodes() {
		return this.downTaskNodes;
	}
	
	public void setDownTaskNodes(List<TaskNode> downTaskNodes) {
		this.downTaskNodes = downTaskNodes;
	}
}
