import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {BrowserModule} from "@angular/platform-browser";
import {BookRoutingModule} from './book-routing.module';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {BookListComponent} from './book-list/book-list.component';
import {BookFormComponent} from './book-form/book-form.component';
import {BookDetailsComponent} from './book-details/book-details.component';
import {NgbModule} from "@ng-bootstrap/ng-bootstrap";

@NgModule({
  imports: [
    BrowserModule,
    CommonModule,
    BookRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    NgbModule.forRoot()
  ],
  declarations: [BookListComponent, BookFormComponent, BookDetailsComponent]
})
export class BookModule { }
