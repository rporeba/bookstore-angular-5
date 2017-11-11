package edu.rporeba.bookstore.assembler;

import java.util.List;
import java.util.stream.Collectors;

import edu.rporeba.bookstore.dto.BorrowerDto;
import edu.rporeba.bookstore.model.Borrower;

public class BorrowerDtoAssembler {

	public static BorrowerDto toDto(Borrower borrower) {

		BorrowerDto borrowerDto = new BorrowerDto();

		borrowerDto.setBorrowerId(borrower.getBorrowerId());
		borrowerDto.setFirstName(borrower.getFirstName());
		borrowerDto.setLastName(borrower.getLastName());

		return borrowerDto;

	}

	public static List<BorrowerDto> dtoList(List<Borrower> borrowers) {

		return borrowers.stream().map(BorrowerDtoAssembler::toDto).collect(Collectors.toList());

	}

	public static Borrower toEntity(BorrowerDto borrowerDto) {

		Borrower borrower = new Borrower();

		borrower.setBorrowerId(borrower.getBorrowerId());
		borrower.setFirstName(borrowerDto.getFirstName());
		borrower.setLastName(borrowerDto.getLastName());

		return borrower;

	}

}
