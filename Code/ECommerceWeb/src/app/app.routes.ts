import { Route } from '@angular/router';
import { HomeComponent } from './pages/shop/home/home.component';
import { CartComponent } from './pages/shop/cart/cart.component';
import { ErrorPageComponent } from './pages/error-page/error-page.component';
import { CheckoutComponent } from './pages/shop/checkout/checkout.component';
import { OrdersComponent } from './pages/shop/orders/orders.component';
import { ProfileComponent } from './pages/shop/profile/profile.component';
import { LoginComponent } from './pages/auth/login/login.component';
import { RegisterComponent } from './pages/auth/register/register.component';
import { ContactUsComponent } from './pages/shop/contact-us/contact-us.component';
import { PaymentComponent } from './pages/shop/payment/payment.component';
import { WishListComponent } from './pages/shop/wish-list/wish-list.component';
import { AdminHomeComponent } from './pages/admin/admin-home/admin-home.component';
import { AdminDashboardComponent } from './pages/admin/admin-dashboard/admin-dashboard.component';
import { AdminCategoriesComponent } from './pages/admin/admin-categories/admin-categories.component';
import { AdminProductsComponent } from './pages/admin/admin-products/admin-products.component';
import { AdminOrdersComponent } from './pages/admin/admin-orders/admin-orders.component';
import { ProductDetailsComponent } from './pages/shop/product-details/product-details.component';

export const appRoutes: Route[] = [
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent },
  { path: 'product/:id', component: ProductDetailsComponent },
  { path: 'category/:id', component: ProductDetailsComponent },
  { path: 'cart', component: CartComponent },
  { path: 'checkout', component: CheckoutComponent },
  { path: 'orders', component: OrdersComponent },
  { path: 'orders/:id', component: OrdersComponent },
  { path: 'profile', component: ProfileComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'contact-us', component: ContactUsComponent },
  { path: 'payment', component: PaymentComponent },
  { path: 'wish-list', component: WishListComponent },
  { path: 'error-page', component: ErrorPageComponent },
  {
    path: 'admin',
    component: AdminHomeComponent,
    children: [
      { path: '', redirectTo: 'dashboard', pathMatch: 'full' },
      { path: 'dashboard', component: AdminDashboardComponent },
      { path: 'categories', component: AdminCategoriesComponent },
      { path: 'products', component: AdminProductsComponent },
      { path: 'orders', component: AdminOrdersComponent },
      { path: '**', redirectTo: 'dashboard' }
    ]
  },
  { path: '**', redirectTo: 'error-page' }
];
