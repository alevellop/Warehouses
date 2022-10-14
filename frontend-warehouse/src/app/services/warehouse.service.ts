import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Warehouse } from '../models/warehouse.model';

@Injectable({
  providedIn: 'root'
})
export class WarehouseService {

  private baseUrl = "/api/warehouses";

  constructor(private http: HttpClient) { }

  getAll(): Observable<Warehouse[]>{
    return this.http.get<Warehouse[]>(this.baseUrl);
  }

  getById(id: number): Observable<Warehouse>{
    return this.http.get<Warehouse>(this.baseUrl +'/'+ id);
  }

  create(warehouse: Warehouse): Observable<Warehouse>{
    return this.http.post<Warehouse>(this.baseUrl, warehouse);
  }

  update(id: number, warehouse: Warehouse): Observable<Warehouse>{
    return this.http.put<Warehouse>(this.baseUrl + '/' + id, warehouse);
  }

  delete(id: number): Observable<Warehouse>{
    return this.http.delete<Warehouse>(this.baseUrl + '/' + id);
  }

}
