package edu.rporeba.bookstore.dto;

import edu.rporeba.bookstore.model.BookType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
public class BookDto implements Serializable {

    private static final long serialVersionUID = 7431962765814176191L;

    private Long itemId;

    @NotNull
    @Length(min = 3, max = 20)
    private String isbn;

    @NotNull
    @Length(min = 3, max = 20)
    private String bookTitle;

    private BookType typeOfBook;

    @NotNull
    private Long numberOfPage;

    @Valid
    @DateTimeFormat(pattern = "MM-dd-yyyy")
    @NotNull
    private LocalDate published;

//    @Valid
//    private boolean isBookBorrowed;

    @Valid
    private AuthorDto authorDto;

    private ItemDto itemDto;

    private BorrowerDto borrowerDto;

    private BorrowDto borrowDto;


}
