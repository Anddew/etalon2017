package com.netcracker.project.validation;

import org.springframework.stereotype.Component;

@Component
public class Validator {

    public boolean validatePassword(String password, String repeatPassword) {
        if(password == null || repeatPassword == null) {
            return false;
        }
        return password.equals(repeatPassword);
    }

}
