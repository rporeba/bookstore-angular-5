import { Injectable } from '@angular/core';
import { Book } from "./Book";
import { Http, Response } from "@angular/http";
import 'rxjs/add/operator/map'
import 'rxjs/add/operator/catch';
import { Observable } from "rxjs/Observable";

@Injectable()
export class BookService {

  private apiUrl = 'http://localhost:8087/bookstore/books';

  constructor(private http: Http) {
  }

  getAllBooks(): Observable<Book[]> {
    return this.http.get(this.apiUrl)
      .map((res:Response) => res.json())
      .catch((error:any) => Observable.throw(error.json().error || 'Server error when fetching all books'));
  }

  findBookById(id: number): Observable<Book> {
    return this.http.get(this.apiUrl + "/" + id )
      .map((res:Response) => res.json())
      .catch((error:any) => Observable.throw(error.json().error || 'Server error when finding a book by id'));
  }

  createBook(book: Book): Observable<Book> {
    return this.http.post(this.apiUrl, book)
      .map((res:Response) => res.json())
      .catch((error:any) => Observable.throw(error.json().error || 'Server error when creating a new book'));
  }

  updateBook(book: Book): Observable<Book> {
    return this.http.put(this.apiUrl, book)
      .map((res:Response) => res.json())
      .catch((error:any) => Observable.throw(error.json().error || 'Server error when updating an existing book'));
  }

  deleteBookById(id: number): Observable<boolean> {
    return this.http.delete(this.apiUrl + "/" + id)
      .map((res:Response) => res.json())
      .catch((error:any) => Observable.throw(error.json().error || 'Server error when deleting an existing book'));
  }

}
