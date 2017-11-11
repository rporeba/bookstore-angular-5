package edu.rporeba.bookstore.dto;

import edu.rporeba.bookstore.model.Borrow;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
public class ItemDto implements Serializable {

    private static final long serialVersionUID = -5150563725536767167L;

    private Long id;

    private Set<Borrow> borrows;

    private boolean isBookBorrowed;
}
