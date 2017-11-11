package edu.rporeba.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.rporeba.bookstore.model.Borrow;

public interface BorrowRepository extends JpaRepository<Borrow, Long> {

}
