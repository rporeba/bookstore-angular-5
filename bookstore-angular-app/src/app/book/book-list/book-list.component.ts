import {Component, OnInit, ViewEncapsulation} from '@angular/core';
import {Book} from "../Book";
import {BookService} from "../book.service";
import {Router} from '@angular/router';
import {NgbModal} from "@ng-bootstrap/ng-bootstrap";

@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.css'],
  encapsulation: ViewEncapsulation.None,
  providers: [BookService]
})
export class BookListComponent implements OnInit {

  private books: Book[];
  private bookForm: Book;
  private selectedBook: Book;
  private isButtonDisabled = true;

  onSelectionChange(book) {
    this.selectedBook = (<any>Object).assign({}, this.selectedBook, book);
    this.isButtonDisabled = false;
  }

  constructor(
    private router: Router,
    private bookService: BookService,
    private modalService: NgbModal) { }

  ngOnInit() {
    this.getAllBooks();
  }

  getAllBooks() {
    this.bookService.getAllBooks().subscribe(
      books => { this.books = books; },
      errrors => { console.log(errrors);}
    );
    this.isButtonDisabled = true;
  }

  deleteBook() {
    this.bookService.deleteBookById(this.selectedBook.itemId).subscribe(
      res => { this.getAllBooks();
        console.log('Book has been deleted successfully');
      })
  }

  redirectBookDetailsPage() {
    this.router.navigate(['/bookstore/bookDetails/', this.selectedBook.itemId])
  }

  open(book) {

    this.modalService.open(book);
    console.log(this.bookForm);
  }

  getBookDetails() {;
    this.bookService.findBookById(this.selectedBook.itemId)
      .subscribe(selectedBook => this.selectedBook = selectedBook);
  }

}
