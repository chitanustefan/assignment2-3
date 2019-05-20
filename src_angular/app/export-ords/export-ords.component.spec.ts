import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ExportOrdsComponent } from './export-ords.component';

describe('ExportOrdsComponent', () => {
  let component: ExportOrdsComponent;
  let fixture: ComponentFixture<ExportOrdsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ExportOrdsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ExportOrdsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
