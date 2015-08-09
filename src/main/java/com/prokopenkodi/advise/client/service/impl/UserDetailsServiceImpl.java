package com.prokopenkodi.advise.client.service.impl;

import com.prokopenkodi.advise.client.classes.AdviseWebException;
import com.prokopenkodi.advise.client.classes.SecurityRole;
import com.prokopenkodi.advise.client.pojo.AuthUser;
import com.prokopenkodi.advise.client.pojo.User;
import com.prokopenkodi.advise.client.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user;
        try {
            user = userService.getUserByEmail(email);
        } catch (AdviseWebException e) {
            throw new UsernameNotFoundException(email);
        }
        Set<GrantedAuthority> roles = new HashSet<>();
        roles.add(new SimpleGrantedAuthority(SecurityRole.ROLE_USER.name()));
        AuthUser result = new AuthUser(email, user.getPassword(), roles);
        result.setLogin(user.getLogin());
        result.setId(user.getId());
        return result;
    }
}
