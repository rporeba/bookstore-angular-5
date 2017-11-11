package edu.rporeba.bookstore.repository;

import edu.rporeba.bookstore.model.Book;
import edu.rporeba.bookstore.model.Item;
import org.springframework.data.repository.Repository;

public interface ItemRepository extends Repository<Item, Long> {

	Book findByItemId(Long id);
}
