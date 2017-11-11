import { Component, OnInit, ViewEncapsulation } from '@angular/core';

@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class BookListComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}
