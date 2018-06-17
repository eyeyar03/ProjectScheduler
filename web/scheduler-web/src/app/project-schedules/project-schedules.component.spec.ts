import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProjectSchedulesComponent } from './project-schedules.component';

describe('ProjectSchedulesComponent', () => {
  let component: ProjectSchedulesComponent;
  let fixture: ComponentFixture<ProjectSchedulesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProjectSchedulesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProjectSchedulesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
