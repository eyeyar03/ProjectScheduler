package com.project.plans.scheduler.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class TaskNodeSorter implements NodeSorter {

	/**
	 * This method sort and arrange tasks with the consideration of their dependencies.
	 * For each iteration, the method will check if there is/are task dependencies and will repeatedly arrange the list of taskNodes
	 * Dependencies will be inserted in the list before the task.
	 * To avoid duplicate, the method also checks if the task to be added is not yet in the list.
	 */
	@Override
	public List<TaskNode> sort(Map<String, TaskNode> map) {
		List<TaskNode> taskNodes = new ArrayList<>();

		// iterate items from map
		map.forEach((key, taskNode) -> {
			
			if(!taskNode.getDownTaskNodes().isEmpty()) {
				int insertionIndex = -1;
				for(TaskNode node : taskNode.getDownTaskNodes()) {
					if(taskNodes.contains(node)) {
						if(insertionIndex < 0) {
							insertionIndex = taskNodes.indexOf(node);
							
						} else {
							insertionIndex = Math.min(insertionIndex, taskNodes.indexOf(node));
						}
						
					} else {
						taskNodes.add(node);
						
						if(insertionIndex < 0) {
							insertionIndex = taskNodes.indexOf(node);
						
						} else {
							insertionIndex = Math.min(insertionIndex, taskNodes.indexOf(node));
						}
						
					}
				}
				
				if(insertionIndex >= 0) {
					if(taskNodes.contains(taskNode)) {
						taskNodes.remove(taskNode);
						insertionIndex = insertionIndex - 1;
						insertionIndex = insertionIndex < 0 ? 0 : insertionIndex;
						taskNodes.add(insertionIndex, taskNode);
						
						if(!taskNode.geUpTaskNodes().isEmpty()) {
							taskNodes.removeAll(taskNode.geUpTaskNodes());
							
							int tempIndex = taskNodes.indexOf(taskNode);
							taskNodes.addAll(tempIndex, taskNode.geUpTaskNodes());
						}
						
					} else {
						taskNodes.add(insertionIndex, taskNode);
					}
							
				} else {
					if(!taskNodes.contains(taskNode)) {
						taskNodes.add(taskNode);
					}
				}
			
			// this is for nodes without downTasks
			} else {
				if(!taskNodes.contains(taskNode)) {
					taskNodes.add(taskNode);
				}
			}
		});
		
		return taskNodes;
	}
}
