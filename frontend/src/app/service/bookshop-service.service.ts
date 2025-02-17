import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Bookshop } from '../models/bookshop';

@Injectable({
  providedIn: 'root'
})
export class BookshopService {
 private gatewayURL:string;
  constructor(private http: HttpClient) {
    this.gatewayURL = 'http://localhost:8080/api';
  }

  public findAllBookshops(): Observable<Bookshop[]> {
    return this.http.get<Bookshop[]>(`${this.gatewayURL}/bookshops`);
  }

  public saveBookshop(bookshop: Bookshop) {
    return this.http.post<Bookshop>(`${this.gatewayURL}/bookshops`, bookshop);
  }
  public getBookshopById(id:string): Observable<Bookshop>{
    return this.http.get<Bookshop>(`${this.gatewayURL}/bookshops/${id}`);
  }
  
  public editBookshop(id: string, bookshop: Bookshop): Observable<Bookshop> {
      return this.http.put<Bookshop>(`${this.gatewayURL}/booksshops/${id}`, bookshop);
    }
}
