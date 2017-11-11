package edu.rporeba.bookstore.service;


import com.google.common.collect.Lists;
import com.querydsl.core.BooleanBuilder;
import edu.rporeba.bookstore.assembler.BookDtoAssembler;
import edu.rporeba.bookstore.dto.BookDto;
import edu.rporeba.bookstore.dto.BookSearchParams;
import edu.rporeba.bookstore.model.Book;
import edu.rporeba.bookstore.model.QAuthor;
import edu.rporeba.bookstore.model.QBook;
import edu.rporeba.bookstore.repository.BookRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    private static final QBook qbook = QBook.book;
    private static final QAuthor qauthor = QAuthor.author;

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book saveBook(BookDto bookDto) {
        Book book = BookDtoAssembler.toEntity(bookDto);

        if (book.getItemId() == null) {
            bookRepository.save(book);

        } else {
            bookRepository.saveAndFlush(book);
        }

        return book;
    }

    @Override
    public List<BookDto> findAll() {
        List<Book> books = bookRepository.findAll();
        List<BookDto> bookDtoList = BookDtoAssembler.dtoList(books);

        return bookDtoList;

    }

    @Override
    public BookDto findByBookId(Long id) {
        Book book = bookRepository.findOne(id);
        BookDto bookDto = BookDtoAssembler.toDto(book);

        return bookDto;

    }

    @Override
    public void deleteBookById(Long id) {
        Book book = bookRepository.findOne(id);
        bookRepository.delete(book);

    }

    @Override
    public Book findById(Long id) {
        Book book = bookRepository.findOne(id);
        return book;

    }

    @Override
    public BookDto findByIsbnLike(String isbn) {
        return BookDtoAssembler.toDto(bookRepository.findOne(qbook.isbn.like("%" + isbn + "%")));

    }

    @Override
    public BookDto findByBookTitleLike(String bookTitle) {
        return BookDtoAssembler.toDto(bookRepository.findOne(qbook.bookTitle.like("%" + bookTitle + "%")));
    }

    @Override
    public List<BookDto> findBySearchTerm(BookSearchParams params) {

        BooleanBuilder builder = new BooleanBuilder();

        if (StringUtils.isNoneBlank(params.getBookTitle())) {
            builder.and(qbook.bookTitle.like("%" + params.getBookTitle().trim() + "%"));
        }

        if (StringUtils.isNoneBlank(params.getIsbn())) {
            builder.and(qbook.isbn.like("%" + params.getIsbn().trim() + "%"));

        }

        if (StringUtils.isNoneBlank(params.getAuthorFirstName())) {
            builder.and(qauthor.firstName.like("%" + params.getAuthorFirstName().trim() + "%"));
        }

        if (StringUtils.isNoneBlank(params.getAuthorLastName())) {
            builder.and(qauthor.lastName.like("%" + params.getAuthorLastName().trim() + "%"));
        }

        Iterable<Book> books = bookRepository.findAll(builder.getValue());
        List<Book> booksList = Lists.newArrayList(books);

        return booksList.stream().map(BookDtoAssembler::toDto).collect(Collectors.toList());

    }


}
