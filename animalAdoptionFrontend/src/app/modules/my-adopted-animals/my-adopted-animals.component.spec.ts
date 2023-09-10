import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MyAdoptedAnimalsComponent } from './my-adopted-animals.component';

describe('MyAdoptedAnimalsComponent', () => {
  let component: MyAdoptedAnimalsComponent;
  let fixture: ComponentFixture<MyAdoptedAnimalsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [MyAdoptedAnimalsComponent]
    });
    fixture = TestBed.createComponent(MyAdoptedAnimalsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
