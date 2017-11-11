package edu.rporeba.bookstore.dto;

import edu.rporeba.bookstore.model.Item;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
public class BorrowDto implements Serializable {

    private static final long serialVersionUID = -3917497041001328487L;

    private Long id;

    private LocalDate borrowDate;

    private Item item;

    private BorrowerDto borrowerDto;


}
