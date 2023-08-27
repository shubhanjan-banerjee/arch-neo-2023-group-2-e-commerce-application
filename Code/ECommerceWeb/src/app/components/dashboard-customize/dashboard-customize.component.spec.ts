import { ComponentFixture, TestBed } from '@angular/core/testing';
import { DashboardCustomizeComponent } from './dashboard-customize.component';

describe('DashboardCustomizeComponent', () => {
  let component: DashboardCustomizeComponent;
  let fixture: ComponentFixture<DashboardCustomizeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DashboardCustomizeComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(DashboardCustomizeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
