import {Component, OnInit, ViewEncapsulation} from '@angular/core';
import {BookService} from "../book.service";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {NgbModal} from "@ng-bootstrap/ng-bootstrap";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-book-form',
  templateUrl: './book-form.component.html',
  styleUrls: ['./book-form.component.css'],
  encapsulation: ViewEncapsulation.None,
  providers: [BookService]
})
export class BookFormComponent implements OnInit{

  bookForm: FormGroup;

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private bookService: BookService,
    private modalService: NgbModal) {}

  ngOnInit() {
  }

  open(book) {

    this.modalService.open(book);

    this.bookForm = new FormGroup({
      isbn: new FormControl('', Validators.required),
      bookTitle: new FormControl('', Validators.required),
      numberOfPage: new FormControl('', Validators.required),
      typeOfBook: new FormControl('', Validators.required),
      firstName: new FormControl('', Validators.required),
      lastName: new FormControl('', Validators.required)
    });

  }

}
