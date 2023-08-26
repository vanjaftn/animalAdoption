import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegisterLostAndFoundComponent } from './register-lost-and-found.component';

describe('RegisterLostAndFoundComponent', () => {
  let component: RegisterLostAndFoundComponent;
  let fixture: ComponentFixture<RegisterLostAndFoundComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [RegisterLostAndFoundComponent]
    });
    fixture = TestBed.createComponent(RegisterLostAndFoundComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
