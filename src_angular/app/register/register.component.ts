import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Persoana } from '../model/persoana';
import {PersoanaService} from '../service/persoana-service.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})

export class RegisterComponent {

  persoana: Persoana;

  constructor(private route: ActivatedRoute, private router: Router, private userService: PersoanaService) {
    this.persoana = new Persoana();
  }
  onSubmit() {
    this.persoana.role = "user";
    this.userService.save(this.persoana).subscribe(result => this.gotoUserList());
  }
  gotoUserList() {
    this.router.navigate(['/register']);
  }

}
