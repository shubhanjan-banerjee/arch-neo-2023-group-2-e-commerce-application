import { Component, EventEmitter, Input, Output } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'ecommerce-pagination',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './pagination.component.html',
  styleUrls: ['./pagination.component.scss'],
})
export class PaginationComponent {
  @Input() pageSize: number = 10;
  @Input() pageNo: number = 1;
  @Input() totalPages: number = 1;
  @Input() totalCount: number = 0;
  @Input() itemCount: number = 10;
  @Output() gotoPage: EventEmitter<string> = new EventEmitter<string>();

  onPageBtnClicked(pageType: string) {
    this.gotoPage.emit(pageType);
  }
}
