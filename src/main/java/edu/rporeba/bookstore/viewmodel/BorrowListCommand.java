package edu.rporeba.bookstore.viewmodel;

import edu.rporeba.bookstore.dto.BookDto;
import edu.rporeba.bookstore.dto.BorrowDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by rporeba on 30.08.2016.
 */
@Getter
@Setter
public class BorrowListCommand {

    List<BorrowDto> borrowList;
}
