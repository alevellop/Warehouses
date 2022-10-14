import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Rack } from '../models/rack.model';

@Injectable({
  providedIn: 'root'
})
export class RackService {

  private baseUrl = "/api/racks";

  constructor(private http: HttpClient) { }

  getAllRacksByWarehouse(warehouseId: number): Observable<Rack[]>{
    return this.http.get<Rack[]>(warehouseId + "/racks");
  }

  deleteRack(id: number): Observable<Rack>{
    return this.http.delete<Rack>(this.baseUrl + "/" + id);
  }
}
