package edu.rporeba.bookstore.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Optional;

@Getter
@Setter
@Entity
@Table(name = "Book")
public class Book extends Item implements Serializable {

    private static final long serialVersionUID = -7447877676635026239L;

    @NotNull
    @Length(min = 3, max = 20)
    private String isbn;

    @NotNull
    @Length(min = 3, max = 20)
    private String bookTitle;

    @Enumerated(EnumType.STRING)
    private BookType typeOfBook;

    @NotNull
    private Long numberOfPage;

    @NotNull
    @DateTimeFormat(pattern = "MM-dd-yyyy")
    private LocalDate published;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "id")
    private Author author;

    public Optional<Borrow> getMaxBorrow() {
        return getBorrows().stream().reduce((a, b) -> a.getId() > b.getId() ? a : b);
    }

}
