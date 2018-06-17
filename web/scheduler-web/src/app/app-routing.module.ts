import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateProjectComponent } from './create-project/create-project.component';
import { ProjectSchedulesComponent } from './project-schedules/project-schedules.component';


const routes: Routes = [
  {path: 'projects/create', component: CreateProjectComponent},
  {path: 'projects/:id', component: ProjectSchedulesComponent},
  {path: '', redirectTo: '/projects/create', pathMatch: 'full'}

]

@NgModule({
  exports: [ RouterModule ],
  imports: [ RouterModule.forRoot(routes) ]
})
export class AppRoutingModule { }
