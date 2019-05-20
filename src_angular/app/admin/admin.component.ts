import { Component, OnInit } from '@angular/core';
import { Order } from '../model/order';
import { Observable } from 'rxjs';
import { Router, ActivatedRoute } from '@angular/router';
import {RestaurantService} from '../service/restaurant.service';
import {OrderService} from '../service/order.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  orders: Order[];
  id: number;
  ord: Order;

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private restaurantService: RestaurantService,
    private orderService: OrderService) {
   }

  ngOnInit() {
    this.id = +this.route.snapshot.paramMap.get('idUser');
    this.restaurantService.getOrders(this.id).subscribe(
      response => {this.orders = response; }
      );
  }

  changeStatus(order: Order){
    this.restaurantService.changeStatus(order, this.id).subscribe(response => {this.ord = response; });
  }

  exportOrders(){
    this.router.navigate(['/' + this.id + '/admin' + '/export']);
  }

}
