package edu.rporeba.bookstore.viewmodel;

import java.util.List;

import edu.rporeba.bookstore.dto.BookDto;
import edu.rporeba.bookstore.dto.BookDto;

public class BookListCommand {

	List<BookDto> bookList;

	public List<BookDto> getBookList() {
		return bookList;
	}

	public void setBookList(List<BookDto> bookList) {
		this.bookList = bookList;
	}

}
