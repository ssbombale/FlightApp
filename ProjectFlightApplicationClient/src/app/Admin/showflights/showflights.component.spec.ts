import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowflightsComponent } from './showflights.component';

describe('ShowflightsComponent', () => {
  let component: ShowflightsComponent;
  let fixture: ComponentFixture<ShowflightsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ShowflightsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ShowflightsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
