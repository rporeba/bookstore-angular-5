package edu.rporeba.bookstore.service;


import edu.rporeba.bookstore.model.CurrentUser;

/**
 * Created by rporeba on 22.08.2016.
 */
public interface CurrentUserService {

    boolean canAccessUser(CurrentUser currentUser, Long userId);

}
