package edu.rporeba.bookstore.util;

import edu.rporeba.bookstore.model.Borrower;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookAlreadyBorrowedException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private String errMsg;

    private Borrower borrower;

    public BookAlreadyBorrowedException() {
        super();
    }

    public BookAlreadyBorrowedException(String errMsg) {
        this.errMsg = errMsg;
    }

    public BookAlreadyBorrowedException(Borrower borrower) {
        this.borrower = borrower;
    }

}
