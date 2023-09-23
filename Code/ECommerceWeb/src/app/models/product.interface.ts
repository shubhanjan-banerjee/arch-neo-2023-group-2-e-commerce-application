import { Category } from "./category.interface";

export interface Product {
  productId: number;
  productName: string;
  description: string;
  category: Category;
  brand: string;
  discount: string;
  price: number;
  stockQuantity: string;
  imageUrl: string;
  sku: number;
  weight: string;
  isActive: string;
  rating: string;
  reviewsCount: string;
  manufacturerPartNumber: string;
  productUrl: string;
  taxRate: string;
  additionalAttributes: string;
}