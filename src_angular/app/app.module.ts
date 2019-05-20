import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { RestaurantComponent } from './restaurant/restaurant.component';
import { RestaurantDetailComponent } from './restaurantdetail/restaurantdetail.component';
import { MenuComponent } from './menu/menu.component';
import { OrderComponent } from './order/order.component';
import { AdminComponent } from './admin/admin.component';
import { UserComponent } from './user/user.component';
import { GetOrderUserComponent } from './get-order-user/get-order-user.component';
import { ExportOrdsComponent } from './export-ords/export-ords.component';



@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    RestaurantComponent,
    RestaurantDetailComponent,
    MenuComponent,
    OrderComponent,
    AdminComponent,
    UserComponent,
    GetOrderUserComponent,
    ExportOrdsComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
