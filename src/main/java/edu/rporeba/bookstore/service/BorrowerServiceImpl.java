package edu.rporeba.bookstore.service;

import edu.rporeba.bookstore.assembler.BorrowerDtoAssembler;
import edu.rporeba.bookstore.dto.BorrowerDto;
import edu.rporeba.bookstore.model.Borrower;
import edu.rporeba.bookstore.repository.BorrowerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BorrowerServiceImpl implements BorrowerService {

    @Autowired
    private BorrowerRepository borrowerRepository;


    @Override
    public Borrower findById(Long id) {

        Borrower borrower = borrowerRepository.findOne(id);
        //return BorrowerDtoAssembler.toDto(borrower);

        return borrower;
    }

    @Override
    public List<BorrowerDto> findAll() {

        List<Borrower> borrowers = borrowerRepository.findAll();
        return BorrowerDtoAssembler.dtoList(borrowers);

    }

    @Override
    public Borrower removeBorrower(Long id) {
        Borrower borrower = borrowerRepository.findOne(id);
        borrowerRepository.delete(borrower);
        return borrower;
    }


    @Override
    public void saveBorrower(BorrowerDto borrowerDto) {

        Borrower borrower = BorrowerDtoAssembler.toEntity(borrowerDto);

        if (borrower.getBorrowerId() == null) {
            borrowerRepository.save(borrower);

        } else {
            borrowerRepository.saveAndFlush(borrower);
        }

    }

}
