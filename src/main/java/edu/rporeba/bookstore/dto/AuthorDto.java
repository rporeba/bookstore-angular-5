package edu.rporeba.bookstore.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
public class AuthorDto implements Serializable {

    private static final long serialVersionUID = 5619903210184189718L;

    private Long id;

    @NotNull
    @Length(min = 3, max = 20)
    private String firstName;

    @NotNull
    @Length(min = 3, max = 20)
    private String lastName;

}
