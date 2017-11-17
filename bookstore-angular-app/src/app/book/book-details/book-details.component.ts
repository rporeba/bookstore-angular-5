import {Component, Input, OnInit, ViewEncapsulation} from '@angular/core';
import {Router} from "@angular/router";
import {Book} from "../Book";
import {BookService} from "../book.service";
import { ActivatedRoute } from '@angular/router';
import {BorrowService} from "../borrow.service";
import {Borrower} from "../Borrower";

@Component({
  selector: 'app-book-details',
  templateUrl: './book-details.component.html',
  styleUrls: ['./book-details.component.css'],
  encapsulation: ViewEncapsulation.None,
  providers: [BookService, BorrowService]
})
export class BookDetailsComponent implements OnInit {

  borrowers: Borrower[]
  book: Book;

  constructor(
    private router: Router,
    private bookService: BookService,
    private borrowService: BorrowService,
    private route: ActivatedRoute,
  ) { }

  ngOnInit() {
    this.getBookDetails();
    this.getAllBorrowers();
  }

  getBookDetails() {
    const itemId = + this.route.snapshot.paramMap.get('itemId');
    this.bookService.findBookById(itemId).subscribe(book => this.book = book);
  }

  getAllBorrowers() {
    this.borrowService.getAllBorrowers().subscribe(
      borrowers => { this.borrowers = borrowers;
      },
      errrors => { console.log(errrors);}
    );
  }

  redirectBookListPage() {
    this.router.navigate(['/bookstore/books']);
  }

}
