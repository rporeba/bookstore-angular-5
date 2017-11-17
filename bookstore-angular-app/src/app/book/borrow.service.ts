import {Injectable} from '@angular/core';
import {Observable} from "rxjs/Observable";
import {Http, Response} from "@angular/http";
import {Borrower} from "./Borrower";
import 'rxjs/add/operator/map'
import 'rxjs/add/operator/catch';


@Injectable()
export class BorrowService {

  private apiUrl = 'http://localhost:8087/bookstore/borrowers';

  constructor(private http: Http) {
  }

  getAllBorrowers(): Observable<Borrower[]> {
    return this.http.get(this.apiUrl)
      .map((res:Response) => res.json())
      .catch((error:any) => Observable.throw(error.json().error || 'Server error when fetching all borrowers'));
  }

}
