import { ComponentFixture, TestBed } from '@angular/core/testing';
import { DashboardUpdateImageSelectionComponent } from './dashboard-update-image-selection.component';

describe('DashboardUpdateImageSelectionComponent', () => {
  let component: DashboardUpdateImageSelectionComponent;
  let fixture: ComponentFixture<DashboardUpdateImageSelectionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DashboardUpdateImageSelectionComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(DashboardUpdateImageSelectionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
