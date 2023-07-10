export interface Order {
  id: string;
  userId: string;
  products: string[]; // Array of product IDs
  status: string;
  // Add any other properties specific to your order
}
