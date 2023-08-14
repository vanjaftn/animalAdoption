import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SubscribedAnimalsPageComponent } from './subscribed-animals-page.component';

describe('SubscribedAnimalsPageComponent', () => {
  let component: SubscribedAnimalsPageComponent;
  let fixture: ComponentFixture<SubscribedAnimalsPageComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SubscribedAnimalsPageComponent]
    });
    fixture = TestBed.createComponent(SubscribedAnimalsPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
