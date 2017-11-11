package edu.rporeba.bookstore.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class BorrowerDto implements Serializable {

    private static final long serialVersionUID = 6995620757725937556L;

    private Long borrowerId;

    private String firstName;

    private String lastName;


}
