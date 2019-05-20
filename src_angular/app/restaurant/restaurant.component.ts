import { Component, OnInit } from '@angular/core';
import { Restaurant } from '../model/restaurant';
import { Router, ActivatedRoute } from '@angular/router';
import {RestaurantService} from '../service/restaurant.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-restaurant',
  templateUrl: './restaurant.component.html',
  styleUrls: ['./restaurant.component.css']
})
export class RestaurantComponent implements OnInit {

  restaurants: Observable<Restaurant[]>;
  private idUser: string;

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private restaurantService: RestaurantService
  ) { }

  ngOnInit() {
    const id = +this.route.snapshot.paramMap.get('idUser');
    this.restaurantService.getRestaurants(id).subscribe(
      response => {this.restaurants = response; }
      );
    }

    selectRestaurant(idRestaurant: number) {
      this.route.params.forEach((urlParams) => {
        this.idUser = urlParams.idUser;
      });

      this.router.navigate(['/' + this.idUser + '/restaurant' + '/' + idRestaurant]);
    }
}

