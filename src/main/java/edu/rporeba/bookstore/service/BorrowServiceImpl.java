package edu.rporeba.bookstore.service;

import edu.rporeba.bookstore.assembler.BorrowDtoAssembler;
import edu.rporeba.bookstore.dto.BorrowDto;
import edu.rporeba.bookstore.model.Book;
import edu.rporeba.bookstore.model.Borrow;
import edu.rporeba.bookstore.model.Borrower;
import edu.rporeba.bookstore.repository.BorrowRepository;
import edu.rporeba.bookstore.util.BookAlreadyBorrowedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BorrowServiceImpl implements BorrowService {

    @Autowired
    private BorrowRepository borrowRepository;

    @Autowired
    private BookService bookService;

    @Autowired
    private BorrowerService borrowerService;

    @Override
    public BorrowDto findByBorrowId(Long borrowId) {

        return BorrowDtoAssembler.toDto(borrowRepository.findOne(borrowId));
    }

    @Override
    public void saveBorrowBook(Borrow borrow) {

        BorrowDtoAssembler.toDto(borrowRepository.save(borrow));
    }

    @Override
    public void borrowBook(Long itemId, Long borrowerId) {

        Book book = bookService.findById(itemId);
        Borrower borrower = borrowerService.findById(borrowerId);

        Borrow borrow = new Borrow();
        borrow.setBorrower(borrower);
        borrow.setItem(book);

        if (book.isBookBorrowed()) {

            throw new BookAlreadyBorrowedException(borrower.getFirstName());

        } else {

            saveBorrowBook(borrow);
            book.setBookBorrowed(true);

        }

    }

    @Override
    public void giveBookBack(Long id) {

        Borrow borrow = borrowRepository.findOne(id);
        borrowRepository.delete(borrow);

//        borrow.getItem().setBookBorrowed(false);
//
//        if (borrow.getItem().isBookBorrowed() == false) {
//
//            borrowRepository.delete(borrow);
//
//        }

    }

    @Override
    public List<BorrowDto> findAll() {

        return BorrowDtoAssembler.dtoList(borrowRepository.findAll());

    }

}
