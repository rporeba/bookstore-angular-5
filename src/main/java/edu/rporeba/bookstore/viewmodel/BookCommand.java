package edu.rporeba.bookstore.viewmodel;

import edu.rporeba.bookstore.dto.BookDto;
import edu.rporeba.bookstore.dto.BorrowerDto;
import edu.rporeba.bookstore.model.BookType;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class BookCommand {

	@Valid
	private BookDto bookDto;

	private List<BorrowerDto> borrowerList;

	private Map<String, String> enumMap = new LinkedHashMap<>();

	public Map<String, String> getEnumMap() {

		for (BookType type : BookType.values()) {
			enumMap.put(type.name(), type.name());
		}
		return enumMap;
	}

	public void setEnumMap(Map<String, String> enumMap) {

		this.enumMap = enumMap;
	}

}
