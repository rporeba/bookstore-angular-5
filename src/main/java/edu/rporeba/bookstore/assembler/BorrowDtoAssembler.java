package edu.rporeba.bookstore.assembler;

import java.util.List;
import java.util.stream.Collectors;

import edu.rporeba.bookstore.dto.BorrowDto;
import edu.rporeba.bookstore.model.Borrow;

public class BorrowDtoAssembler {

	public static BorrowDto toDto(Borrow borrow) {

		BorrowDto borrowDto = new BorrowDto();

		borrowDto.setId(borrow.getId());
		borrowDto.setBorrowDate(borrow.getBorrowDate());
		borrowDto.setItem(borrow.getItem());
		borrowDto.setBorrowerDto(BorrowerDtoAssembler.toDto(borrow.getBorrower()));

		return borrowDto;

	}

	public static List<BorrowDto> dtoList(List<Borrow> borrows) {

		return borrows.stream().map(BorrowDtoAssembler::toDto).collect(Collectors.toList());

	}

}
