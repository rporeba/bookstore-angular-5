import {Component, OnInit, ViewEncapsulation} from "@angular/core";
import {Book} from "../Book";
import {BookService} from "../book.service";
import {ActivatedRoute, Router} from "@angular/router";
import {NgbModal, NgbModalRef} from "@ng-bootstrap/ng-bootstrap";
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

  itemId: number;
  books: Book[];
  selectedBook: Book;
  modalRef: NgbModalRef;

  bookForm: FormGroup;
  isbn: FormControl;
  bookTitle: FormControl;
  numberOfPage: FormControl;
  published: FormControl;
  typeOfBook: FormControl;
  firstName: FormControl;
  lastName: FormControl;

  isButtonDisabled = true;
  book: Book;
  author: Author;
  sub: any;

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
  }

  open(book) {
    this.modalRef = this.modalService.open(book);
    this.createFormControls();
    this.createForm();
  }

  createFormControls() {
    this.isbn = new FormControl('', Validators.required);
    this.bookTitle = new FormControl('', Validators.required);
    this.numberOfPage = new FormControl('', [Validators.required,]);
    this.published = new FormControl('', [Validators.required,]);
    this.typeOfBook = new FormControl('', Validators.required);
    this.firstName = new FormControl('', Validators.required);
    this.lastName = new FormControl('', Validators.required);
  }
  createForm() {
    this.bookForm = new FormGroup({
      isbn: this.isbn,
      bookTitle: this.bookTitle,
      numberOfPage: this.numberOfPage,
      published: this.published,
      typeOfBook: this.typeOfBook,
      firstName: this.firstName,
      lastName: this.lastName
    },{ updateOn: 'blur' });
  }

  editForm(book) {

    this.modalRef = this.modalService.open(book);
    this.createFormControls();
    this.createForm();

    if (this.selectedBook.itemId) {
      this.bookService.findBookById(this.selectedBook.itemId).subscribe(
        book => {
          this.itemId = book.itemId;
          this.bookForm.patchValue({
            isbn: book.isbn,
            bookTitle: book.bookTitle,
            numberOfPage: book.numberOfPage,
            published: book.published,
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
          this.bookForm.controls['published'].value,
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
          this.bookForm.controls['published'].value,
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
    this.modalRef.close(this.book);
  }

  getAllBooks() {
    this.bookService.getAllBooks().subscribe(
      books => { this.books = books;
      },
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
