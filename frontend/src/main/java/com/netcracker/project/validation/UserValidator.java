package com.netcracker.project.validation;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.regex.Pattern;

@Component
public class UserValidator {

    private Logger logger = Logger.getLogger(UserValidator.class.getSimpleName());

    private static final String USERNAME_USER_PARAMETER = "username";
    private static final String PASSWORD_USER_PARAMETER = "password";
    private static final String PASSWORD_REPEAT_PARAMETER_NAME = "passwordRepeat";
    private static final String EMAIL_PARAMETER_NAME = "email";
    private static final String FIRST_NAME_PARAMETER_NAME = "firstname";
    private static final String LAST_NAME_PARAMETER_NAME = "lastname";
    private static final String GROUP_NUMBER_PARAMETER_NAME = "group";
    private static final String COMPANY_PARAMETER_NAME = "company";
    private static final String FACULTY_PARAMETER_NAME = "faculty";


    private static final String USERNAME_REGEX = "[a-zA-Z0-9]{3,15}";
    private static final String EMAIL_REGEX =
            "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])"
            ;
    private static final String TEXT_FIELD_REGEX = "[a-zA-Z]{2,15}";
    private static final String GROUP_NUMBER_REGEX = "[\\d]{1,10}";

    private final Pattern usernamePattern = Pattern.compile(USERNAME_REGEX);
    private final Pattern emailPattern = Pattern.compile(EMAIL_REGEX);
    private final Pattern textFieldPattern = Pattern.compile(TEXT_FIELD_REGEX);
    private final Pattern groupNumberPattern = Pattern.compile(GROUP_NUMBER_REGEX);

    private boolean validateUsername(String username) {
        return usernamePattern.matcher(username).matches();
    }

    private boolean validatePassword(String password, String repeatPassword) {
        if(password == null || repeatPassword == null) {
            return false;
        }
        logger.debug("Password repeating validation success.");
        return password.equals(repeatPassword);
    }

    private boolean validateEmail(String email) {
        return emailPattern.matcher(email).matches();
    }

    private boolean validateTextField(String text) {
        return textFieldPattern.matcher(text).matches();
    }

    private boolean validateGroupNumber(String groupNumber) {
        return groupNumberPattern.matcher(groupNumber).matches();
    }

    private boolean validateCompanyName(String companyName) {
        return textFieldPattern.matcher(companyName).matches();
    }

    private boolean validateFacultyName(String facultyName) {
        return textFieldPattern.matcher(facultyName).matches();
    }

    public boolean validateUserFields(Map<String,String> userParameters) {
        if(!validateUsername(userParameters.get(USERNAME_USER_PARAMETER))) {
            return false;
        }
        if(!validatePassword(userParameters.get(PASSWORD_USER_PARAMETER), userParameters.get(PASSWORD_REPEAT_PARAMETER_NAME))) {
            return false;
        }
        if(!validateEmail(userParameters.get(EMAIL_PARAMETER_NAME))) {
            return false;
        }
        if(!validateTextField(userParameters.get(FIRST_NAME_PARAMETER_NAME))) {
            return false;
        }
        if(!validateTextField(userParameters.get(LAST_NAME_PARAMETER_NAME))) {
            return false;
        }
        logger.debug("User fields validation success.");
        return true;
    }

    public boolean validateStudentFields(Map<String,String> userParameters) {
        if(!validateGroupNumber(userParameters.get(GROUP_NUMBER_PARAMETER_NAME))) {
            return false;
        }
        logger.debug("Student user fields validation success.");
        return true;
    }

    public boolean validateHeadFromCompanyFields(Map<String,String> userParameters) {
        if(!validateCompanyName(userParameters.get(COMPANY_PARAMETER_NAME))) {
            return false;
        }
        logger.debug("Head from company user fields validation success.");
        return true;
    }

    public boolean validateHeadFromUniversityFields(Map<String,String> userParameters) {
        if(!validateFacultyName(userParameters.get(FACULTY_PARAMETER_NAME))) {
            return false;
        }
        logger.debug("Head from university user fields validation success.");
        return true;
    }

}
