import { Route } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { ProductsComponent } from './pages/products/products.component';
import { CartComponent } from './pages/cart/cart.component';
import { CheckoutComponent } from './pages/checkout/checkout.component';
import { OrdersComponent } from './pages/orders/orders.component';
import { ProfileComponent } from './pages/profile/profile.component';
import { LoginComponent } from './pages/login/login.component';
import { RegisterComponent } from './pages/register/register.component';

/**
 * Home Page:
URL: /
Description: The main landing page of your e-commerce website, displaying featured products, promotions, or any relevant information.
Product Listing Page:
URL: /products
Description: This page displays a list of all products available for purchase. It can include filters, sorting options, and pagination for easier navigation.
Product Details Page:
URL: /products/:id
Description: This page provides detailed information about a specific product. It includes images, descriptions, pricing, and any other relevant details.
Shopping Cart:
URL: /cart
Description: This page shows the items added to the shopping cart. Users can view and update the quantity of items, remove items, and proceed to the checkout process.
Checkout Page:
URL: /checkout
Description: This page allows users to review their cart, enter shipping and payment information, and complete the purchase process.
Order History:
URL: /orders
Description: This page displays a list of the user's previous orders, including order details, status, and tracking information.
Order Confirmation:
URL: /orders/:id
Description: After a successful purchase, this page displays the order confirmation with the order details and a summary of the purchase.
User Profile:
URL: /profile
Description: This page allows registered users to view and update their profile information, including name, email, password, and address.
Login/Registration:
URL: /login
URL: /register
Description: These pages handle user authentication and registration processes.
 */
export const appRoutes: Route[] = [
  { path: '', redirectTo: 'products', pathMatch: 'full' },
  { path: 'home', component: HomeComponent },
  { path: 'products', component: ProductsComponent },
  { path: 'products/:id', component: ProductsComponent },
  { path: 'cart', component: CartComponent },
  { path: 'checkout', component: CheckoutComponent },
  { path: 'orders', component: OrdersComponent },
  { path: 'orders/:id', component: OrdersComponent },
  { path: 'profile', component: ProfileComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
];
