package edu.rporeba.bookstore.dto;

import edu.rporeba.bookstore.model.Role;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by rporeba on 22.08.2016.
 */

@Getter
@Setter
public class UserDto implements Serializable {

    private static final long serialVersionUID = -298586080229657084L;

    @NotEmpty
    private String email = "";

    @NotEmpty
    private String password = "";

    @NotEmpty
    private String passwordRepeated = "";

    @NotNull
    private Role role = Role.USER;

}
