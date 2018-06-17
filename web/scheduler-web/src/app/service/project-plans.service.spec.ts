import { TestBed, inject } from '@angular/core/testing';

import { ProjectPlansService } from './project-plans.service';

describe('ProjectPlansService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ProjectPlansService]
    });
  });

  it('should be created', inject([ProjectPlansService], (service: ProjectPlansService) => {
    expect(service).toBeTruthy();
  }));
});
