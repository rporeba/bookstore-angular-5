import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {BookListComponent} from "./book-list/book-list.component";
import {BookDetailsComponent} from "./book-details/book-details.component";
import {BookFormComponent} from "./book-form/book-form.component";

const routes: Routes = [
  {path: 'bookstore/books', component: BookListComponent},
  {path: 'bookstore/bookDetails/:itemId', component: BookDetailsComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class BookRoutingModule { }
