import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FoundPageComponent } from './found-page.component';

describe('FoundPageComponent', () => {
  let component: FoundPageComponent;
  let fixture: ComponentFixture<FoundPageComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [FoundPageComponent]
    });
    fixture = TestBed.createComponent(FoundPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
