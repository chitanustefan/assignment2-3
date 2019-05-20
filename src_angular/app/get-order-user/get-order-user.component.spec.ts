import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GetOrderUserComponent } from './get-order-user.component';

describe('GetOrderUserComponent', () => {
  let component: GetOrderUserComponent;
  let fixture: ComponentFixture<GetOrderUserComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GetOrderUserComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GetOrderUserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
