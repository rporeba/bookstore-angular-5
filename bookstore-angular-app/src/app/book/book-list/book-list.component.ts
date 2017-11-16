import {Component, OnInit, ViewEncapsulation} from "@angular/core";
import {Book} from "../Book";
import {BookService} from "../book.service";
import {ActivatedRoute, Router} from "@angular/router";
import {NgbModal} from "@ng-bootstrap/ng-bootstrap";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {Author} from "../Author";

@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.css'],
  encapsulation: ViewEncapsulation.None,
  providers: [BookService]
})
export class BookListComponent implements OnInit {

  typesOfBook = ['SCI', 'ADVENTAGE', 'CRIME'];

  private itemId: number;
  private books: Book[];
  selectedBook: Book;
  bookForm: FormGroup;
  private isButtonDisabled = true;
  book: Book;
  private author: Author;
  private sub: any;

  onSelectionChange(book) {
    this.selectedBook = (<any>Object).assign({}, this.selectedBook, book);
    this.isButtonDisabled = false;
  }

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private bookService: BookService,
    private modalService: NgbModal) { }

  ngOnInit() {
    this.getAllBooks();

    this.sub = this.route.params.subscribe(params => {
      this.itemId = params['itemId'];
    });

  }

  ngOnDestroy(): void {
    this.sub.unsubscribe();
  }

  open(book) {

    this.modalService.open(book);


    this.bookForm = new FormGroup({
      //itemId: new FormControl(''),
      isbn: new FormControl('', Validators.required),
      bookTitle: new FormControl('', Validators.required),
      numberOfPage: new FormControl('', Validators.required),
      typeOfBook: new FormControl('', Validators.required),
      firstName: new FormControl('', Validators.required),
      lastName: new FormControl('', Validators.required)
    });

  }

  editForm(book) {

    this.modalService.open(book);

    this.bookForm = new FormGroup({
      itemId: new FormControl(''),
      isbn: new FormControl('', Validators.required),
      bookTitle: new FormControl('', Validators.required),
      numberOfPage: new FormControl('', Validators.required),
      typeOfBook: new FormControl('', Validators.required),
      firstName: new FormControl('', Validators.required),
      lastName: new FormControl('', Validators.required)
    });

    if (this.selectedBook.itemId) {
      this.bookService.findBookById(this.selectedBook.itemId).subscribe(
        book => {
          this.itemId = book.itemId;
          this.bookForm.patchValue({
            isbn: book.isbn,
            bookTitle: book.bookTitle,
            numberOfPage: book.numberOfPage,
            typeOfBook: book.typeOfBook,
            firstName: book.authorDto.firstName,
            lastName: book.authorDto.lastName
          });
        },error => {
          console.log(error);
        }
      );
    }

  }

  onSubmit() {
    if (this.bookForm.valid) {
      if (this.itemId) {
        let book: Book = new Book(this.itemId,
          this.bookForm.controls['isbn'].value,
          this.bookForm.controls['bookTitle'].value,
          this.bookForm.controls['numberOfPage'].value,
          this.bookForm.controls['typeOfBook'].value,
          new Author(
            this.bookForm.controls['firstName'].value,
            this.bookForm.controls['lastName'].value
          )
        );
        this.bookService.updateBook(book).subscribe(
          res => {
            this.getAllBooks();
            console.log('Book has been updated successfully');
          }
        );
      } else {
        let book: Book = new Book(null,
          this.bookForm.controls['isbn'].value,
          this.bookForm.controls['bookTitle'].value,
          this.bookForm.controls['numberOfPage'].value,
          this.bookForm.controls['typeOfBook'].value,
          new Author(
            this.bookForm.controls['firstName'].value,
            this.bookForm.controls['lastName'].value
          )
        );
        this.bookService.createBook(book).subscribe(
          res => {
            this.getAllBooks();
            console.log('Book has been created successfully');
          }
        );
      }
    }
    this.itemId= null;
  }

  getAllBooks() {
    this.bookService.getAllBooks().subscribe(
      books => { this.books = books; },
      errrors => { console.log(errrors);}
    );
    this.isButtonDisabled = true;
  }

  getBookDetails() {;
    this.bookService.findBookById(this.selectedBook.itemId)
      .subscribe(selectedBook => this.selectedBook = selectedBook);
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

}
