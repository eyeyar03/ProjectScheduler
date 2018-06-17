import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Project } from '../model/project';
import { Plan } from '../model/plan';
import { Task } from '../model/task';


@Injectable({
  providedIn: 'root'
})
export class ProjectPlansService {

  private schedulerUrl = 'http://localhost:8080/projectScheduleBuilder';

  private taskIdCounter = 1;

  private planIdCounter = 1;

  constructor(private http: HttpClient) { }

  getProjectPlans(): Plan[] {
    const task1 = new Task('task1', 1, 4);
    const task2 = new Task('task2', 2, 8);
    const plan = new Plan('plan1', 1, [task1, task2]);
    return [plan];
  }

  generateProject(): Project {
    return new Project('My Project', new Date(), [this.createPlan()]);
  }

  createTask(): Task {
    const taskId = this.taskIdCounter++;
    return new Task('Task ' + taskId, taskId, 0);
  }

  createPlan(): Plan {
    const planId = this.planIdCounter++;
    return new Plan('Plan ' + planId, planId, [this.createTask()]);
  }

  addTask(plan: Plan): void {
    plan.tasks.push(this.createTask());
  }

  addPlan(project: Project): void {
    project.plans.push(this.createPlan());
  }

  createProject(project: Project): Observable<Project> {
    const url = `${this.schedulerUrl}/save`;
    return this.http.post<Project>(url, project);
  }

  getProject(id: number): Observable<Project> {
    const url = `${this.schedulerUrl}/projects/${id}`;
    return this.http.get<Project>(url);
  }
}
