import { ComponentFixture, TestBed } from '@angular/core/testing';
import { DashboardTodayOrderTableComponent } from './dashboard-today-order-table.component';

describe('DashboardTodayOrderTableComponent', () => {
  let component: DashboardTodayOrderTableComponent;
  let fixture: ComponentFixture<DashboardTodayOrderTableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DashboardTodayOrderTableComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(DashboardTodayOrderTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
