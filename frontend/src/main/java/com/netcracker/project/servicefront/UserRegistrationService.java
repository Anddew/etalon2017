package com.netcracker.project.servicefront;

import com.netcracker.project.bean.user.UserViewModel;
import com.netcracker.project.exception.RegistrationException;

import java.util.Map;

public interface UserRegistrationService {

    void register(UserViewModel user, Map<String, String> parameters) throws RegistrationException;

}
