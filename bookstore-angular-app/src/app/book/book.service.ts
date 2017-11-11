import { Injectable } from '@angular/core';
import { Book } from "./Book";
import { Http, Response } from "@angular/http";
import 'rxjs/add/operator/map'
import 'rxjs/add/operator/catch';
import { Observable } from "rxjs/Observable";

@Injectable()
export class BookService {

  private apiUrl = 'http://localhost:8081/bookstore/books';

  constructor(private http: Http) {
  }

  getAllBooks(): Observable<Book[]> {
    return this.http.get(this.apiUrl)
      .map((res:Response) => res.json())
      .catch((error:any) => Observable.throw(error.json().error || 'Server error'));
  }

}
