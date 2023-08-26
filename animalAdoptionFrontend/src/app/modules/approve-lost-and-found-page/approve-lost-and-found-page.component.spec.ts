import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ApproveLostAndFoundPageComponent } from './approve-lost-and-found-page.component';

describe('ApproveLostAndFoundPageComponent', () => {
  let component: ApproveLostAndFoundPageComponent;
  let fixture: ComponentFixture<ApproveLostAndFoundPageComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ApproveLostAndFoundPageComponent]
    });
    fixture = TestBed.createComponent(ApproveLostAndFoundPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
