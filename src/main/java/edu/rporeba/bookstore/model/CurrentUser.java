package edu.rporeba.bookstore.model;

/**
 * Created by rporeba on 22.08.2016.
 */

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.authority.AuthorityUtils;

@Getter
@Setter
public class CurrentUser extends org.springframework.security.core.userdetails.User {

    private User user;

    public CurrentUser(User user) {
        super(user.getEmail(), user.getPasswordHash(), AuthorityUtils.createAuthorityList(user.getRole().toString()));
        this.user = user;
    }

    public Long getId() {
        return user.getId();
    }

    public Role getRole() {
        return user.getRole();
    }

    @Override
    public String toString() {
        return "CurrentUser{" +
                "user=" + user +
                '}';
    }

}
