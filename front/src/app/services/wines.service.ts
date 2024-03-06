import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, tap } from 'rxjs';
import { Wine } from '../model/wine';

const API_URL :string = "http://localhost:4200"

@Injectable({
  providedIn: 'root'
})
export class WinesService {
  $fetchWines: Observable<Wine[]>;
  private _wines : Wine[] = [];

  constructor(private _httpClient: HttpClient) { 
    this.$fetchWines = this._httpClient.get<Wine[]>(`${API_URL}/api/wines`)
    .pipe(
      tap((wines) => this._wines = wines)
    )
  }

  get wines() { return this._wines;}
}
