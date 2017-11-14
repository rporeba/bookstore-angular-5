import {Author} from "./Author";
import {Borrower} from "./Borrower";

export class Book {

  itemId: number;
  isbn: string;
  bookTitle: string;
  numberOfPage: number;
  published: object;
  typeOfBook: string;
  authorDto: Author;
  borrowerDto: Borrower;


  constructor(itemId: number, isbn: string, bookTitle: string, numberOfPage: number, published: Object, typeOfBook: string, authorDto: Author, borrowerDto: Borrower) {
    this.itemId = itemId;
    this.isbn = isbn;
    this.bookTitle = bookTitle;
    this.numberOfPage = numberOfPage;
    this.published = published;
    this.typeOfBook = typeOfBook;
    this.authorDto = authorDto;
    this.borrowerDto = borrowerDto;
  }
}
