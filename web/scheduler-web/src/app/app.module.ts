import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { CreateProjectComponent } from './create-project/create-project.component';
import { AppRoutingModule } from './/app-routing.module';
import { ProjectSchedulesComponent } from './project-schedules/project-schedules.component';


@NgModule({
  declarations: [
    AppComponent,
    CreateProjectComponent,
    ProjectSchedulesComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
