package edu.rporeba.bookstore.assembler;

import edu.rporeba.bookstore.dto.BookDto;
import edu.rporeba.bookstore.model.Book;

import java.util.List;
import java.util.stream.Collectors;

public class BookDtoAssembler {

    public static BookDto toDto(Book book) {

        BookDto bookDto = new BookDto();

        bookDto.setItemId(book.getItemId());
        bookDto.setIsbn(book.getIsbn());
        //bookDto.setBookBorrowed(book.isBookBorrowed());
        bookDto.setBookTitle(book.getBookTitle());
        bookDto.setTypeOfBook(book.getTypeOfBook());
        bookDto.setNumberOfPage(book.getNumberOfPage());
        bookDto.setPublished(book.getPublished());
        bookDto.setAuthorDto(AuthorDtoAssembler.toDto(book.getAuthor()));
        book.getMaxBorrow().ifPresent(max -> bookDto.setBorrowerDto(BorrowerDtoAssembler.toDto(max.getBorrower())));

        return bookDto;

    }

    public static List<BookDto> dtoList(List<Book> books) {

        return books.stream().map(BookDtoAssembler::toDto).collect(Collectors.toList());

    }

    public static Book toEntity(BookDto bookDto) {

        Book book = new Book();

        book.setItemId(bookDto.getItemId());
        book.setIsbn(bookDto.getIsbn());
        //book.setBookBorrowed(bookDto.isBookBorrowed());
        book.setBookTitle(bookDto.getBookTitle());
        book.setTypeOfBook(bookDto.getTypeOfBook());
        book.setNumberOfPage(bookDto.getNumberOfPage());
        book.setPublished(bookDto.getPublished());
        book.setAuthor(AuthorDtoAssembler.toEntity(bookDto.getAuthorDto()));

        return book;

    }

}

