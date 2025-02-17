import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Book } from '../models/book';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BookService {

  //private usersUrl: string;
  private gatewayURL:string;
  constructor(private http: HttpClient) {
    this.gatewayURL = 'http://localhost:8080/api';
  }

  public findAllBooks(): Observable<Book[]> {
    return this.http.get<Book[]>(`${this.gatewayURL}/books`);
  }

  public saveBook(book: Book) {
    return this.http.post<Book>(`${this.gatewayURL}/books`, book);
  }

  getBookById(id: string): Observable<Book> {
    return this.http.get<Book>(`${this.gatewayURL}/books/${id}`);
  }

  public editBook(id: string, book: Book): Observable<Book> {
    return this.http.put<Book>(`${this.gatewayURL}/books/${id}`, book);
  }
}