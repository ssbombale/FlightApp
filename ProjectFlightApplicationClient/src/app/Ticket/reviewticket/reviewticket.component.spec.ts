import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReviewticketComponent } from './reviewticket.component';

describe('ReviewticketComponent', () => {
  let component: ReviewticketComponent;
  let fixture: ComponentFixture<ReviewticketComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ReviewticketComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ReviewticketComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
