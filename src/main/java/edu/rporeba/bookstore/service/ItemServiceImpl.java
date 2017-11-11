package edu.rporeba.bookstore.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.rporeba.bookstore.model.Book;
import edu.rporeba.bookstore.repository.ItemRepository;

@Transactional
@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemRepository itemRepository;

	@Override
	public Book findByItemId(Long id) {
		return itemRepository.findByItemId(id);
	}

}
