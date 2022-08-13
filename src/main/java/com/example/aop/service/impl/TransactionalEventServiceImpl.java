package com.example.aop.service.impl;

import com.example.aop.annotation.Transactional;
import com.example.aop.service.TransactionalEventService;
import org.springframework.stereotype.Service;

@Service
public class TransactionalEventServiceImpl implements TransactionalEventService {

    @Override
    @Transactional
    public void getUserById(String id) {
        System.out.println("getUser : " + id.toString());
    }
}
