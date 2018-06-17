import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ProjectPlansService } from '../service/project-plans.service';
import { Project } from '../model/project';

@Component({
  selector: 'app-project-schedules',
  templateUrl: './project-schedules.component.html',
  styleUrls: ['./project-schedules.component.css']
})
export class ProjectSchedulesComponent implements OnInit {

  project: Project;

  constructor( private route: ActivatedRoute, private projectPlansService: ProjectPlansService ) { }

  ngOnInit() {
    const projectId = this.route.snapshot.paramMap.get('id');

    this.projectPlansService.getProject(parseInt(projectId, 10)).subscribe( data => {
      this.project = data;
    });
  }

}
