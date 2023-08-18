import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegisterVetComponent } from './register-vet.component';

describe('RegisterVetComponent', () => {
  let component: RegisterVetComponent;
  let fixture: ComponentFixture<RegisterVetComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [RegisterVetComponent]
    });
    fixture = TestBed.createComponent(RegisterVetComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
