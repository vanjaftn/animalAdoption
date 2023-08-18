import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateVaccineComponent } from './create-vaccine.component';

describe('CreateVaccineComponent', () => {
  let component: CreateVaccineComponent;
  let fixture: ComponentFixture<CreateVaccineComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CreateVaccineComponent]
    });
    fixture = TestBed.createComponent(CreateVaccineComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
