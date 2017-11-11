package edu.rporeba.bookstore.service;



import edu.rporeba.bookstore.dto.UserDto;
import edu.rporeba.bookstore.model.User;

import java.util.Collection;
import java.util.Optional;

/**
 * Created by rporeba on 22.08.2016.
 */
public interface UserService {

    Optional<User> getUserById(long id);
    Optional<User> getUserByEmail(String email);
    Collection<User> getAllUsers();
    User create(UserDto form);

}
