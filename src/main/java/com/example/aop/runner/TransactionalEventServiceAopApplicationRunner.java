package com.example.aop.runner;

import com.example.aop.config.proxy.TransactionalEventServiceProxy;
import com.example.aop.service.TransactionalEventService;
import com.example.aop.service.impl.TransactionalEventServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionalEventServiceAopApplicationRunner implements ApplicationRunner {

    private final TransactionalEventService transactionalEventService;

    public TransactionalEventServiceAopApplicationRunner() {
        transactionalEventService = new TransactionalEventServiceProxy(new TransactionalEventServiceImpl());
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        transactionalEventService.getUserById("Commit");
//        transactionalEventService.getUserById(null);
    }
}
