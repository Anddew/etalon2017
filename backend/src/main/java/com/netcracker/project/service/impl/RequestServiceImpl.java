package com.netcracker.project.service.impl;

import com.netcracker.project.repository.RequestRepository;
import com.netcracker.project.repository.StudentRepository;
import com.netcracker.project.repository.UserRepository;
import com.netcracker.project.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestServiceImpl implements RequestService {

    @Autowired
    private RequestRepository requestRepository;

    public RequestRepository getRequestRepository() {
        return requestRepository;
    }

}
