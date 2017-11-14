import {Component, OnInit, ViewEncapsulation} from "@angular/core";
import {Book} from "../Book";
import {BookService} from "../book.service";
import {Router, ActivatedRoute} from "@angular/router";
import {NgbModal} from "@ng-bootstrap/ng-bootstrap";
import {FormGroup, Validators, FormControl} from "@angular/forms";
import {Author} from "../Author";
import {NgForm} from '@angular/forms';

@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.css'],
  encapsulation: ViewEncapsulation.None,
  providers: [BookService]
})
export class BookListComponent implements OnInit {

  private itemId: number;
  private books: Book[];
  private selectedBook: Book;
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


/*    this.sub = this.route.params.subscribe(params => {
      this.itemId = params['itemId'];
    });

    if (this.itemId) { //edit form
      this.bookService.findBookById(this.itemId).subscribe(
        book => {
          this.itemId = this.book.itemId;
          this.bookForm.patchValue({
              isbn: this.book.isbn,
              bookTitle: this.book.bookTitle,
              numberOfPage: this.book.numberOfPage,
              published: this.book.published,
              typeOfBook: this.book.typeOfBook

/!*
          let author: Author = new Author(
            this.bookForm.controls['firstName'].value,
            this.bookForm.controls['lastName'].value*!/


          });
        },error => {
          console.log(error);
        }
      );

    }*/

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
    this.bookForm = new FormGroup({});
    this.modalService.open(book);

    this.bookForm = new FormGroup({
      isbn: new FormControl('', Validators.required),
      bookTitle: new FormControl('', Validators.required),
      numberOfPage: new FormControl('', Validators.required),
      typeOfBook: new FormControl('', Validators.required),
      firstName: new FormControl('', Validators.required),
      lastName: new FormControl('', Validators.required)

/*      lastName: new FormControl('', Validators.required),
      email: new FormControl('', [
        Validators.required,
        Validators.pattern("[^ @]*@[^ @]*")
      ])*/
    });



  }

  onSubmit() {

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
/*      res => { this.getAllBooks();
        console.log('Book has been deleted successfully');
      }*/
    );
    console.log(book.authorDto);
    console.log(book.authorDto.firstName);

/*    if (this.bookForm.valid) {
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
          res => { this.getAllBooks();
            console.log('Book has been deleted successfully');
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
          res => { this.getAllBooks();
            console.log('Book has been deleted successfully');
          }
        );
      }

      //this.bookForm.reset();
      //this.router.navigate(['/bookstore/books']);

    }*/
  }



  getBookDetails() {;
    this.bookService.findBookById(this.selectedBook.itemId)
      .subscribe(selectedBook => this.selectedBook = selectedBook);
  }

}
