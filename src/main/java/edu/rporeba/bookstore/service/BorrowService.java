package edu.rporeba.bookstore.service;

import edu.rporeba.bookstore.dto.BorrowDto;
import edu.rporeba.bookstore.model.Borrow;

import java.util.List;

public interface BorrowService {

	BorrowDto findByBorrowId(Long borrowId);
	void saveBorrowBook(Borrow borrow);
	void borrowBook(Long itemId, Long borrowerId);
	void giveBookBack(Long id);
	List<BorrowDto> findAll();

}
