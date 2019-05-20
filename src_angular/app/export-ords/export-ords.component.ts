import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ActivatedRoute } from '@angular/router';
import { OrderService } from '../service/order.service'

@Component({
  selector: 'app-export-ords',
  templateUrl: './export-ords.component.html',
  styleUrls: ['./export-ords.component.css']
})
export class ExportOrdsComponent implements OnInit {

  private urlbasic = '//localhost:8080';

  constructor(private http: HttpClient,
              private route: ActivatedRoute,
              private orderService: OrderService ){}

  ngOnInit() {
    const id = +this.route.snapshot.paramMap.get('idUser');
    console.log(id);
    this.orderService.exportOrders(id).subscribe();
  }

}
