import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UnadoptedAnimalsPageComponent } from './unadopted-animals-page.component';

describe('UnadoptedAnimalsPageComponent', () => {
  let component: UnadoptedAnimalsPageComponent;
  let fixture: ComponentFixture<UnadoptedAnimalsPageComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [UnadoptedAnimalsPageComponent]
    });
    fixture = TestBed.createComponent(UnadoptedAnimalsPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
