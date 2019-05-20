import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Persoana } from '../model/persoana';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PersoanaService {

  private usersUrlReg: string;
  private usersUrlLog: string;

  constructor(private http: HttpClient) {
    this.usersUrlReg = 'http://localhost:8080/register';
    this.usersUrlLog = 'http://localhost:8080/login';
  }

  public save(persoana: Persoana) {
    return this.http.post<Persoana>(this.usersUrlReg, persoana);
  }

  public login(persoana: Persoana):Observable<Persoana>{
    return this.http.post<Persoana>(this.usersUrlLog, persoana);
  }

}
