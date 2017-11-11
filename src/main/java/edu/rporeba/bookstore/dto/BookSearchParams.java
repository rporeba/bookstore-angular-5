package edu.rporeba.bookstore.dto;

import edu.rporeba.bookstore.model.BookType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookSearchParams {

	private String isbn;
	private String bookTitle;
	private BookType typeOfBook;
	private String authorFirstName;
	private String authorLastName;

}
