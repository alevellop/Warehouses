import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { RacksType } from '../models/racks-type.model';

@Injectable({
  providedIn: 'root'
})
export class RacksTypeService {

  private baseURL = "/api/racks-type";

  constructor(private http: HttpClient) { }

  getAll(): Observable<RacksType[]>{
    return this.http.get<RacksType[]>(this.baseURL);
  }

  getByFamily(family: string): Observable<RacksType>{
    return this.http.get<RacksType>(this.baseURL + '/' + family);
  }

  getAllFamilies(): Observable<string[]>{
    return this.http.get<string[]>(this.baseURL + "/families");
  }
}
