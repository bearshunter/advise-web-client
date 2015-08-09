package com.prokopenkodi.advise.client.pojo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class AuthUser extends org.springframework.security.core.userdetails.User {

    public AuthUser(String email, String password, Collection<? extends GrantedAuthority> authorities) {
        super(email, password, authorities);
    }

    @Getter
    @Setter
    private String login;

    @Getter
    @Setter
    private Long id;

}
