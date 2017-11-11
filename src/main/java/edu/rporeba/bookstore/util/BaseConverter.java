package edu.rporeba.bookstore.util;

import java.util.List;
import java.util.stream.Collectors;

@FunctionalInterface
public interface BaseConverter<F, T> {

	public T toDTO(F from);

	default public List<T> convertAll(List<F> fElements) {
		List<T> convertedElement = fElements.stream().map(element -> toDTO(element)).collect(Collectors.toList());

		return convertedElement;
	}

}
