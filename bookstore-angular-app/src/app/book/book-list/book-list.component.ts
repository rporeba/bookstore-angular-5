import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { Book } from "../Book";
import { BookService} from "../book.service";

@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.css'],
  encapsulation: ViewEncapsulation.None,
  providers: [BookService]
})
export class BookListComponent implements OnInit {

  private books: Book[];

  constructor(private bookService: BookService) { }

  ngOnInit() {
    this.getAllUsers();
  }

  getAllUsers() {
    this.bookService.getAllBooks().subscribe(
      books => {
        this.books = books;
      },
      err => {
        console.log(err);
      }
    );
  }

}
