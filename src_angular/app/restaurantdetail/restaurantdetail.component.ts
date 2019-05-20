import { Component, OnInit } from '@angular/core';
import { ActivatedRoute,Router } from '@angular/router';
import {RestaurantService} from '../service/restaurant.service';
import { Category } from '../model/category';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-restaurantdetail',
  templateUrl: './restaurantdetail.component.html',
  styleUrls: ['./restaurantdetail.component.css']
})
export class RestaurantDetailComponent implements OnInit {

  categories: Observable<Category[]>;
  private idUser: number;
  private idRestaurant: number;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private restaurantService: RestaurantService
  ) {  }

  ngOnInit() {
    this.getCategories();
  }

  getCategories(): void {
    this.route.params.forEach((urlParams) => {
      this.idUser = urlParams.idUser; 
      this.idRestaurant = urlParams.idRestaurant; 
    });
    this.restaurantService.getCat(this.idUser, this.idRestaurant)
      .subscribe(response =>{this.categories = response;});
    
  }

  selectCategory(idCategorie: number): void {
    this.route.params.forEach((urlParams) => {
      this.idUser = urlParams.idUser; 
      this.idRestaurant = urlParams.idRestaurant; 
    });
    this.restaurantService.getCat(this.idUser, this.idRestaurant)
      .subscribe(response =>{this.categories = response;});
    
      this.router.navigate(['/'+this.idUser+'/restaurant/' + this.idRestaurant + '/' + idCategorie]);
  }

}
