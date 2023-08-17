import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdoptionRequestsPageComponent } from './adoption-requests-page.component';

describe('AdoptionRequestsPageComponent', () => {
  let component: AdoptionRequestsPageComponent;
  let fixture: ComponentFixture<AdoptionRequestsPageComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AdoptionRequestsPageComponent]
    });
    fixture = TestBed.createComponent(AdoptionRequestsPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
