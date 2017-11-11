package edu.rporeba.bookstore.service;

import org.springframework.security.core.GrantedAuthority;

import java.util.List;

/**
 * Created by rporeba on 22.08.2016.
 */
public interface UserDetails {

    List<? extends GrantedAuthority> getAuthorities();
    String getPassword();
    String getUsername();
    boolean isAccountNonExpired();
    boolean isAccountNonLocked();
    boolean isCredentialsNonExpired();
    boolean isEnabled();

}
