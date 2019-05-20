import { Component, OnInit } from '@angular/core';
import { ActivatedRoute,Router } from '@angular/router';
import {RestaurantService} from '../service/restaurant.service';
import { Subcategory } from '../model/subcat';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

  subcats: Observable<Subcategory[]>;
  idUser: number;
  catid: number;
  idRestaurant: number;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private restaurantService: RestaurantService
  ) { }

  ngOnInit() {
    this.getSubCategories();
  }

  getSubCategories(): void {
    this.route.params.forEach((urlParams) => {
      this.idUser = urlParams.idUser;
      this.idRestaurant = urlParams.idRestaurant;
      this.catid = urlParams.category;

    });
    this.restaurantService.getSubCat(this.idUser, this.idRestaurant, this.catid)
      .subscribe(response =>{this.subcats = response;});
  }

  placeOrder(item1: number): void{
    this.restaurantService.placeOrder(this.idUser,this.idRestaurant, this.catid, item1).subscribe(response =>{this.subcats = response;
      
      this.router.navigate(['/order']);}); 
  }
}
