import { TestBed } from '@angular/core/testing';

import { PersoanaServiceService } from './persoana-service.service';

describe('PersoanaServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: PersoanaServiceService = TestBed.get(PersoanaServiceService);
    expect(service).toBeTruthy();
  });
});
