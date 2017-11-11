package edu.rporeba.bookstore.service;

import edu.rporeba.bookstore.dto.BookDto;
import edu.rporeba.bookstore.dto.BookSearchParams;
import edu.rporeba.bookstore.model.Book;

import java.util.List;

public interface BookService {

    Book saveBook(BookDto bookDto);

    void deleteBookById(Long id);

    List<BookDto> findAll();

    BookDto findByBookId(Long id);

    Book findById(Long id);

    List<BookDto> findBySearchTerm(BookSearchParams searchTerm);

    BookDto findByIsbnLike(String isbn);

    BookDto findByBookTitleLike(String bookTitle);


}
