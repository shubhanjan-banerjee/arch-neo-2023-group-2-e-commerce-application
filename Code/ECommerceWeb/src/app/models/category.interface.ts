export interface Category {
  categoryId: number;
  categoryName: string;
  parentCategory: number;
  description: string;
  imageUrl: string;
  displayOrder: number;
  slug: number;
  metaTitle: string;
  metaDescription: string;
  metaKeywords: string;
  customAttributes: string;
  active: boolean;
}