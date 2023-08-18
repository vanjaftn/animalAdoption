import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AnimalVaccinesComponent } from './animal-vaccines.component';

describe('AnimalVaccinesComponent', () => {
  let component: AnimalVaccinesComponent;
  let fixture: ComponentFixture<AnimalVaccinesComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AnimalVaccinesComponent]
    });
    fixture = TestBed.createComponent(AnimalVaccinesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
