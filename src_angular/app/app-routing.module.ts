import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { AppComponent } from './app.component';
import { RegisterComponent } from './register/register.component';
import { RestaurantComponent } from './restaurant/restaurant.component';
import { RestaurantDetailComponent } from './restaurantdetail/restaurantdetail.component';
import { MenuComponent } from './menu/menu.component';
import { OrderComponent } from './order/order.component';
import { AdminComponent } from './admin/admin.component';
import { UserComponent } from './user/user.component';
import { ExportOrdsComponent } from './export-ords/export-ords.component';
import { GetOrderUserComponent } from './get-order-user/get-order-user.component';

const routes: Routes = [
  { path: '', component: AppComponent},
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: ':idUser', component: UserComponent },
  { path: ':idUser/getOrders', component: GetOrderUserComponent },
  { path: ':idUser/admin/export', component: ExportOrdsComponent },
  { path: ':idUser/restaurant', component: RestaurantComponent },
  { path: ':idUser/restaurant/:idRestaurant', component: RestaurantDetailComponent },
  { path: ':idUser/restaurant/:idRestaurant/:category', component: MenuComponent },
  { path: 'order', component: OrderComponent },
  { path: ':idUser/admin', component: AdminComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
