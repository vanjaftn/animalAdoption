import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateAnimalPageComponent } from './update-animal-page.component';

describe('UpdateAnimalPageComponent', () => {
  let component: UpdateAnimalPageComponent;
  let fixture: ComponentFixture<UpdateAnimalPageComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [UpdateAnimalPageComponent]
    });
    fixture = TestBed.createComponent(UpdateAnimalPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
