import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AccordionModule } from 'primeng/accordion';
import {ProductsComponent} from '../products/products.component';

@Component({
  selector: 'ecommerce-home',
  standalone: true,
  imports: [CommonModule, AccordionModule, ProductsComponent],
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss'],
})
export class HomeComponent { }
