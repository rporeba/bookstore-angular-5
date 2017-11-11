package edu.rporeba.bookstore.repository;

import edu.rporeba.bookstore.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;


public interface BookRepository extends JpaRepository<Book, Long>, QueryDslPredicateExecutor<Book> {

}
