package com.example.aop.config.proxy;

import com.example.aop.service.TransactionalEventService;

public class TransactionalEventServiceProxy implements TransactionalEventService {

    private final TransactionalEventService service;

    public TransactionalEventServiceProxy(TransactionalEventService service) {
        this.service = service;
    }

    @Override
    public void getUserById(String id) {
        // DB 커넥션
        System.out.println("DB Connection");
        try {
            service.getUserById(id);
            // DB commit
            System.out.println("DB Commit");
        } catch (RuntimeException e) {
            // DB rollback
            System.out.println("DB Rollback");
        }
    }
}
