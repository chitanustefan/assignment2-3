import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {


  private idUser: string;

  constructor(private route: ActivatedRoute, private router: Router) {
  }

  ngOnInit() {
  }

  selectRestaurant() {
    this.route.params.forEach((urlParams) => {
      this.idUser = urlParams.idUser;
    });

    this.router.navigate(['/' + this.idUser + '/restaurant']);
  }

  getOrders(){
    this.route.params.forEach((urlParams) => {
      this.idUser = urlParams.idUser;
    });

    this.router.navigate(['/' + this.idUser + '/getOrders']);
  }

}
