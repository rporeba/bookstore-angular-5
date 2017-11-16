import {Author} from "./Author";

export class Book {

  itemId: number;
  isbn: string;
  bookTitle: string;
  numberOfPage: string;
  published: Date;
  typeOfBook: string;
  authorDto: Author;

  constructor(itemId: number, isbn: string, bookTitle: string, numberOfPage: string, published: Date, typeOfBook: string, authorDto: Author) {
    this.itemId = itemId;
    this.isbn = isbn;
    this.bookTitle = bookTitle;
    this.numberOfPage = numberOfPage;
    this.published = published;
    this.typeOfBook = typeOfBook;
    this.authorDto = authorDto;
  }

}
