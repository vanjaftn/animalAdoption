import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LostAndFoundPageComponent } from './lost-and-found-page.component';

describe('LostAndFoundPageComponent', () => {
  let component: LostAndFoundPageComponent;
  let fixture: ComponentFixture<LostAndFoundPageComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [LostAndFoundPageComponent]
    });
    fixture = TestBed.createComponent(LostAndFoundPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
