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
  private selectedBook;

  onSelectionChange(book) {
    this.selectedBook = Object.assign({}, this.selectedBook, book);
    console.log(book.itemId);
    console.log(book);
  }

  constructor(private bookService: BookService) { }

  ngOnInit() {
    this.getAllUsers();
  }

  getAllUsers() {
    this.bookService.getAllBooks().subscribe(
      books => { this.books = books; },
      errrors => { console.log(errrors);}
    );
  }

  deleteBook() {
      this.bookService.deleteBookById(this.selectedBook.itemId).subscribe(
        res => {this.getAllUsers();
          console.log('Book has been deleted successfully');
        }
      )
  }



}
