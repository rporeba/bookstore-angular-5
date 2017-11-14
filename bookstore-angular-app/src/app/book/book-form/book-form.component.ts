import {Component, OnDestroy, OnInit, ViewEncapsulation} from '@angular/core';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {BookService} from "../book.service";
import {Book} from "../Book";

@Component({
  selector: 'app-book-form',
  templateUrl: './book-form.component.html',
  styleUrls: ['./book-form.component.css'],
  encapsulation: ViewEncapsulation.None,
  providers: [BookService]
})
export class BookFormComponent implements OnInit, OnDestroy {

  private book: Book;
  private sub: any;

  constructor(private modalService: NgbModal,
              private bookService: BookService,) {}

  ngOnInit() {
  }

  open(book) {
    this.modalService.open(book);
  }

  ngOnDestroy(): void {
    this.sub.unsubscribe();
  }
}
