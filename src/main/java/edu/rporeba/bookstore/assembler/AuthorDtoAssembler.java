package edu.rporeba.bookstore.assembler;

import java.util.List;
import java.util.stream.Collectors;

import edu.rporeba.bookstore.dto.AuthorDto;
import edu.rporeba.bookstore.dto.AuthorDto;
import edu.rporeba.bookstore.model.Author;

public class AuthorDtoAssembler {

	public static AuthorDto toDto(Author author) {

		AuthorDto authorDto = new AuthorDto();

		authorDto.setId(author.getId());
		authorDto.setFirstName(author.getFirstName());
		authorDto.setLastName(author.getLastName());

		return authorDto;

	}

	public static List<AuthorDto> dtoList(List<Author> authors) {

		return authors.stream().map(AuthorDtoAssembler::toDto).collect(Collectors.toList());

	}

	public static Author toEntity(AuthorDto authorDto) {

		Author author = new Author();

		author.setId(authorDto.getId());
		author.setFirstName(authorDto.getFirstName());
		author.setLastName(authorDto.getLastName());

		return author;
	}

}
