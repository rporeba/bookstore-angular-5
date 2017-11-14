import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { BookRoutingModule } from './book-routing.module';
import { BookListComponent } from './book-list/book-list.component';
import { BookFormComponent } from './book-form/book-form.component';

@NgModule({
  imports: [
    CommonModule,
    BookRoutingModule
  ],
  declarations: [BookListComponent, BookFormComponent]
})
export class BookModule { }
