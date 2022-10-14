import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Permutation } from '../models/permutation.model';

@Injectable({
  providedIn: 'root'
})
export class PermutationService {

  private baseURL = "/api/permutations";

  constructor(private http: HttpClient) { }

  getAll(): Observable<Permutation[]>{
    return this.http.get<Permutation[]>(this.baseURL);
  }
}
