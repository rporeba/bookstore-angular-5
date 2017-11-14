import {Author} from "./Author";

export class Book {

  itemId: number;
  isbn: string;
  bookTitle: string;
  numberOfPage: number;
  typeOfBook: string;
  authorDto: Author;

  constructor(itemId: number, isbn: string, bookTitle: string, numberOfPage: number, typeOfBook: string, authorDto: Author) {
    this.itemId = itemId;
    this.isbn = isbn;
    this.bookTitle = bookTitle;
    this.numberOfPage = numberOfPage;
    this.typeOfBook = typeOfBook;
    this.authorDto = authorDto;
  }
}
