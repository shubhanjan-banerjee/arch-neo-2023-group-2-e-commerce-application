import { ComponentFixture, TestBed } from '@angular/core/testing';
import { DashboardTodaySellComponent } from './dashboard-today-sell.component';

describe('DashboardTodaySellComponent', () => {
  let component: DashboardTodaySellComponent;
  let fixture: ComponentFixture<DashboardTodaySellComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DashboardTodaySellComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(DashboardTodaySellComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
