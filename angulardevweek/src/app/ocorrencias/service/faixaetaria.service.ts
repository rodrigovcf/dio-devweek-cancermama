import { Injectable } from '@angular/core';
import { Faixaetaria } from '../model/Faixaetaria';
import {HttpClient} from '@angular/common/http'
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FaixaetariaService {

  constructor(
    private http:HttpClient
  ) { }

  listFaixaEtaria(): Observable<Faixaetaria[]>{    
      const url = '/api/faixaetaria'
      return this.http.get<Faixaetaria[]>(url);
    
  }
}