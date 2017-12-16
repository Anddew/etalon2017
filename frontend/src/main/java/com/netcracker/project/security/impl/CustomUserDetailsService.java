package com.netcracker.project.security.impl;

import com.netcracker.project.bean.user.UserViewModel;
import com.netcracker.project.bean.user.UserViewModelFactory;
import com.netcracker.project.entity.user.UserEntity;
import com.netcracker.project.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

public class CustomUserDetailsService implements UserDetailsService {

    private Logger logger = Logger.getLogger(CustomUserDetailsService.class.getSimpleName());

    private static final String USER_NOT_FOUND_MESSAGE = "User not found. No matches username: ";

    @Autowired
    private UserService userService;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        UserEntity user = userService.findUserByUserName(username);
        if (user == null) {
            logger.warn("No such user found: '" + username + "'.");
            throw new UsernameNotFoundException(USER_NOT_FOUND_MESSAGE + username);
        }
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole().toString()));
        return new User(user.getUsername(), user.getPassword(), authorities);
    }

}