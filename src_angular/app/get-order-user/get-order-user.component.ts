import { Component, OnInit } from '@angular/core';
import { Order } from '../model/order';
import { Router, ActivatedRoute } from '@angular/router';
import { OrderService} from '../service/order.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-get-order-user',
  templateUrl: './get-order-user.component.html',
  styleUrls: ['./get-order-user.component.css']
})
export class GetOrderUserComponent implements OnInit {

  orders: Observable<Order[]>;

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private orderService: OrderService
  ) { }

  ngOnInit() {
    const id = +this.route.snapshot.paramMap.get('idUser');
    this.orderService.getOrders(id).subscribe(
      response => {this.orders = response; }
      );
  }

}
