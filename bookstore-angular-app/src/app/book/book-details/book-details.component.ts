import {Component, Input, OnInit, ViewEncapsulation} from '@angular/core';
import {Router} from "@angular/router";
import {Book} from "../Book";
import {BookService} from "../book.service";
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-book-details',
  templateUrl: './book-details.component.html',
  styleUrls: ['./book-details.component.css'],
  encapsulation: ViewEncapsulation.None,
  providers: [BookService]
})
export class BookDetailsComponent implements OnInit {

  private book: Book;

  constructor(
    private router: Router,
    private bookService: BookService,
    private route: ActivatedRoute,
  ) { }

  ngOnInit() {
    this.getBookDetails();
  }

  getBookDetails() {
    const itemId = + this.route.snapshot.paramMap.get('itemId');
    this.bookService.findBookById(itemId).subscribe(book => this.book = book);
  }

  redirectBookListPage() {
    this.router.navigate(['/bookstore/books']);
  }

}
