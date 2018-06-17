import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ProjectPlansService } from '../service/project-plans.service';
import { Project } from '../model/project';
import { Plan } from '../model/plan';
import { Task } from '../model/task';

@Component({
  selector: 'app-create-project',
  templateUrl: './create-project.component.html',
  styleUrls: ['./create-project.component.css']
})
export class CreateProjectComponent implements OnInit {

  showCreateBtn = true;
  showProjectForm = false;
  project: Project;

  constructor( private router: Router, private projectPlansService: ProjectPlansService ) { }

  ngOnInit() {
    this.project = this.projectPlansService.generateProject();
  }

  addProject(project: Project): void {
    this.projectPlansService.createProject(project).subscribe(data => {
      this.project = data;
      this.router.navigate(['/projects/' + this.project.id]);
    });

  }

  displayProjectForm(): void {
    this.showCreateBtn = false;
    this.showProjectForm = true;
  }

  addTask(plan: Plan): void {
    this.projectPlansService.addTask(plan);
  }

  removeTask(plan: Plan, task: Task): void {
   const planIndex = this.project.plans.indexOf(plan);
   const taskIndex = this.project.plans[planIndex].tasks.indexOf(task);
   this.project.plans[planIndex].tasks.splice(taskIndex, 1);
  }

  addPlan(project: Project): void {
    this.projectPlansService.addPlan(project);
  }

}
