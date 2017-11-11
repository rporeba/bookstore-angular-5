package edu.rporeba.bookstore.service;

import java.util.List;

import edu.rporeba.bookstore.dto.AuthorDto;
import edu.rporeba.bookstore.model.Author;

public interface AuthorService {

	List<Author> findAll();
	AuthorDto findByAuthorId(Long id);
}
