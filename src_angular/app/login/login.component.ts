import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Persoana } from '../model/persoana';
import {PersoanaService} from '../service/persoana-service.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {


  persoana: Persoana;
  user: Persoana;

  constructor(private route: ActivatedRoute, private router: Router, private userService: PersoanaService) {
    this.persoana = new Persoana();
  }
  onSubmit() {
    this.userService.login(this.persoana).subscribe(x => {this.persoana =x;
    if(this.persoana.role === "user")
      this.router.navigate(['/' + this.persoana.idUser]);
    else this.router.navigate(['/' + this.persoana.idUser + '/admin']); } 
    );
  }
}
