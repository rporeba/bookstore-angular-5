package edu.rporeba.bookstore.repository;

import edu.rporeba.bookstore.model.Borrower;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowerRepository extends JpaRepository<Borrower, Long> {

}
