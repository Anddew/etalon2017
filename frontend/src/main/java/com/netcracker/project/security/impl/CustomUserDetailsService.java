package com.netcracker.project.security.impl;

import com.netcracker.project.bean.user.UserViewModel;
import com.netcracker.project.bean.user.UserViewModelFactory;
import com.netcracker.project.entity.user.UserEntity;
import com.netcracker.project.service.UserService;
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

    private static final String USER_NOT_FOUND_MESSAGE = "User not found. No matches username: ";

    @Autowired
    private UserService userService;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        UserEntity user = userService.findUserByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException(USER_NOT_FOUND_MESSAGE + username);
        }
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole().toString()));
//        return buildUserForAuthentication(user, authorities);
        return new User(user.getUsername(), user.getPassword(), authorities);

    }


    private CustomUser buildUserForAuthentication(UserEntity user, List<GrantedAuthority> authorities) {
        UserViewModel userViewModel = UserViewModelFactory.getViewModel(user.getRole());
        userViewModel.setUsername(user.getUsername());
        userViewModel.setPassword(user.getPassword());
        userViewModel.setAuthorities(authorities);
        userViewModel.setFirstName(user.getFirstName());
        userViewModel.setLastName(user.getLastName());
        userViewModel.setId(String.valueOf(user.getId()));
        userViewModel.setEmail(user.getEmail());
        System.out.println("!!!!! 2 " + userViewModel);
        return userViewModel;
    }

}