import { Product } from "./product.interface";

export interface Cart {
  product: Product;
  quantity: number;
  price?: number;
}