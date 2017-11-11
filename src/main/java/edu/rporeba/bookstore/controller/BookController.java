package edu.rporeba.bookstore.controller;

import edu.rporeba.bookstore.dto.BookDto;
import edu.rporeba.bookstore.dto.BookSearchParams;
import edu.rporeba.bookstore.dto.BorrowerDto;
import edu.rporeba.bookstore.service.BookService;
import edu.rporeba.bookstore.service.BorrowerService;
import edu.rporeba.bookstore.viewmodel.BookCommand;
import edu.rporeba.bookstore.viewmodel.BookListCommand;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class BookController {

    final static Logger logger = Logger.getLogger(BookController.class);

    @Autowired
    private BookService bookService;

    @Autowired
    private BorrowerService borrowerService;

    @PreAuthorize("hasAuthority('ADMIN') OR hasAuthority('USER') OR hasAuthority('DBA')")
    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public String getAllBooks(@ModelAttribute("command") BookListCommand command) {

        List<BookDto> bookList = bookService.findAll();
        command.setBookList(bookList);

        return "home";

    }

    @PreAuthorize("hasAuthority('ADMIN') OR hasAuthority('USER')")
    @RequestMapping(value = "/bookdetails/{id}", method = RequestMethod.GET)
    public String bookDetails(@PathVariable("id") Long id, @ModelAttribute("command") BookCommand command) {

        BookDto bookDto = bookService.findByBookId(id);
        command.setBookDto(bookDto);

        List<BorrowerDto> borrowerList = borrowerService.findAll();
        command.setBorrowerList(borrowerList);

        return "bookDetails";

    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/newbook", method = RequestMethod.GET)
    public String addBook(@Valid @ModelAttribute("command") BookCommand command) {

        BookDto bookDto = new BookDto();
        command.setBookDto(bookDto);

        return "bookForm";
    }

    @PreAuthorize("hasAuthority('ADMIN') OR hasAuthority('DBA')")
    @RequestMapping(value = "/savebook", method = RequestMethod.POST)
    public String saveBook(@Valid @ModelAttribute("command") BookCommand command, BindingResult result) {

        if (result.hasErrors()) {
            return "bookForm";

        } else
            bookService.saveBook(command.getBookDto());

        return "redirect:/books";

    }

    @PreAuthorize("hasAuthority('DBA')")
    @RequestMapping(value = "/editbook/{id}", method = RequestMethod.GET)
    public String editBook(@PathVariable("id") Long id, @ModelAttribute("command") BookCommand command) {

        BookDto bookDto = bookService.findByBookId(id);
        command.setBookDto(bookDto);

        return "bookForm";

    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/deletebook", method = RequestMethod.POST)
    public String deleteBook(@RequestParam("itemId") Long itemId) {

        bookService.deleteBookById(itemId);
        return "redirect:/books";

    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String getSearchPage(@ModelAttribute("command") BookCommand command) {

        return "search";

    }

    @RequestMapping(value = "/search", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<BookDto> search(@ModelAttribute("command") BookListCommand command, @RequestBody BookSearchParams searchTerm) {

        List<BookDto> bookDto;
        bookDto = bookService.findBySearchTerm(searchTerm);
        command.setBookList(bookDto);
        return bookDto;

    }

    @RequestMapping(value = "/searchIsbn", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public BookDto searchByISBN(@ModelAttribute("command") BookCommand command, @RequestParam("isbn") String isbn) {

        BookDto bookDto = bookService.findByIsbnLike(isbn);
        command.setBookDto(bookDto);
        return bookDto;

    }

    @RequestMapping(value = "/searchBookTitle", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public BookDto searchBookTitle(@ModelAttribute("command") BookCommand command, @RequestParam("bookTitle") String bookTitle) {

        BookDto bookDto = bookService.findByBookTitleLike(bookTitle);
        command.setBookDto(bookDto);
        return bookDto;

    }

}
