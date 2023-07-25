import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  standalone: true,
  imports: [CommonModule],
  selector: 'ecommerce-banner',
  templateUrl: './banner.component.html',
})
export class BannerComponent implements OnInit {
  constructor() { }

  ngOnInit(): void { }
}
