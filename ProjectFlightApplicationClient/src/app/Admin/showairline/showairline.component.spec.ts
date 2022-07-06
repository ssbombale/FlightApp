import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowairlineComponent } from './showairline.component';

describe('ShowairlineComponent', () => {
  let component: ShowairlineComponent;
  let fixture: ComponentFixture<ShowairlineComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ShowairlineComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ShowairlineComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
