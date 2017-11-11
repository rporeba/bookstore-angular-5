package edu.rporeba.bookstore.service;

import edu.rporeba.bookstore.model.Book;

public interface ItemService {

	Book findByItemId(Long id);
	
}
