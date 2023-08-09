import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdoptedAnimalsPageComponent } from './adopted-animals-page.component';

describe('AdoptedAnimalsPageComponent', () => {
  let component: AdoptedAnimalsPageComponent;
  let fixture: ComponentFixture<AdoptedAnimalsPageComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AdoptedAnimalsPageComponent]
    });
    fixture = TestBed.createComponent(AdoptedAnimalsPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
