package com.project.plans.scheduler.business;

import java.util.List;
import java.util.Map;

public interface NodeSorter {
	
	List<TaskNode> sort(Map<String, TaskNode> map);

}
