package edu.rporeba.bookstore.viewmodel;

import edu.rporeba.bookstore.dto.BorrowerDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by rporeba on 15.07.2016.
 */

@Getter
@Setter
public class BorrowerCommand {

    private BorrowerDto borrowerDto;

    private List<BorrowerDto> borrowerList;

}
