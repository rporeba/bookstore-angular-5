package edu.rporeba.bookstore.controller;

import edu.rporeba.bookstore.dto.BookDto;
import edu.rporeba.bookstore.dto.BookSearchParams;
import edu.rporeba.bookstore.service.BookService;
import edu.rporeba.bookstore.service.BorrowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/books")
public class BookController {

    private final BookService bookService;
    private final BorrowerService borrowerService;

    @Autowired
    public BookController(BookService bookService, BorrowerService borrowerService) {
        this.bookService = bookService;
        this.borrowerService = borrowerService;
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<BookDto>> getAllBooks() {

        List<BookDto> books = bookService.findAll();
        if (books.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BookDto> getBookDetails(@PathVariable("id") Long id) {
        BookDto bookDto = bookService.findByBookId(id);

        if (bookDto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(bookDto, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<Void> createBook(@RequestBody BookDto bookDto) {

        bookService.saveBook(bookDto);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @RequestMapping( method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BookDto> updateBook( @RequestBody BookDto bookDto) {

        bookService.saveBook(bookDto);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(headers, HttpStatus.OK);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BookDto> deleteBook(@PathVariable("id") Long id) {

        BookDto bookDto = bookService.findByBookId(id);
        if (bookDto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        bookService.deleteBookById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public ResponseEntity<List<BookDto>> findBySearchTerm(@RequestBody BookSearchParams params) {

        List<BookDto> bookDTO = bookService.findBySearchTerm(params);
        if (bookDTO.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>( HttpStatus.OK);
    }















//----------------------------------------------------------------------------------------

    /*

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

    */

}
