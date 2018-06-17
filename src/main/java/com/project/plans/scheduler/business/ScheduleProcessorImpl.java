package com.project.plans.scheduler.business;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.plans.scheduler.model.Plan;
import com.project.plans.scheduler.model.Project;
import com.project.plans.scheduler.model.Task;

@Component
public class ScheduleProcessorImpl implements ScheduleProcessor {
	
	@Autowired
	private NodeSorter nodeSorter;
	
	public Project process(Project project) {
		if(project != null) {
			Date projectStartDate = project.getStartDate();
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(projectStartDate);
			
			for(Plan plan : project.getPlans()) {
				
				// convert to tasks to map for easy retrieval per GUI ID
				Map<String, Task> tasksMap = plan.getTasks().stream().collect(Collectors.toMap(Task::getGuiId, Function.identity()));
				
				Map<String, TaskNode> taskNodeMap = new HashMap<>();
				
				TaskNode taskNode = null;
				for(Task task : plan.getTasks()) {
					
					// create task nodes and put in map
					if(taskNodeMap.containsKey(task.getGuiId())) {
						taskNode = taskNodeMap.get(task.getGuiId());
					} else {
						taskNode = new TaskNode(task.getGuiId());
						taskNodeMap.put(taskNode.getData(), taskNode);
					}
					
					// process task's dependencies as upTaskNode and add dependencies as task's downTaskNode
					if(task.getDependsOn() != null && !task.getDependsOn().isEmpty()) {
						String[] tasks = task.getDependsOn().split(",");
						
						for(String taskId : tasks) {
							taskId = taskId.trim();
							
							TaskNode taskNodeTemp;
							
							if(taskNodeMap.containsKey(taskId)) {
								taskNodeTemp = taskNodeMap.get(taskId);
								
							} else {
								taskNodeTemp = new TaskNode(taskId);
								taskNodeMap.put(taskNodeTemp.getData(), taskNodeTemp);
							}
							
							taskNode.addUpTaskNode(taskNodeTemp);
							taskNodeTemp.addDownTaskNode(taskNode);
						}
					}
				}
				
				// sort and arrange nodes based on dependencies
				List<TaskNode> taskNodes = nodeSorter.sort(taskNodeMap);
				
				List<Task> newTaskList = new ArrayList<>();
				
				// Tasks are now arranged from here. Create new task list for each plan.
				taskNodes.forEach( node -> {
					newTaskList.add(tasksMap.get(node.getData()));
				});
				
				// Iterate each task and set start and end date
				newTaskList.forEach(task -> {
					task.setStartDate(calendar.getTime());
					calendar.add(Calendar.DATE, task.getDuration());
					task.setEndDate(calendar.getTime());
				});
				
				plan.setTasks(newTaskList);
			}
		}
		 
		return project;
	}
}
