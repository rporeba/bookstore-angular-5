package edu.rporeba.bookstore.service;


import edu.rporeba.bookstore.dto.BorrowerDto;
import edu.rporeba.bookstore.model.Borrower;

import java.util.List;


public interface BorrowerService {

    void saveBorrower(BorrowerDto borrowerDto);

    Borrower findById(Long id);

    List<BorrowerDto> findAll();

    Borrower removeBorrower(Long id);
    //BorrowerDto findById(Long id);

}
