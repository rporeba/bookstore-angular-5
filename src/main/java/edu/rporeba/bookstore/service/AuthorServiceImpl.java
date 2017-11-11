package edu.rporeba.bookstore.service;

import java.util.List;

import javax.transaction.Transactional;

import edu.rporeba.bookstore.dto.AuthorDto;
import edu.rporeba.bookstore.model.Author;
import edu.rporeba.bookstore.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.rporeba.bookstore.assembler.AuthorDtoAssembler;

@Service
@Transactional
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	private AuthorRepository authorRepository;

	@Override
	@Transactional
	public List<Author> findAll() {
		return authorRepository.findAll();
	}

	@Override
	public AuthorDto findByAuthorId(Long id) {
		return AuthorDtoAssembler.toDto((authorRepository.findOne(id)));
	}


}
