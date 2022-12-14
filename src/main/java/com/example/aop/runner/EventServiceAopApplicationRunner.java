package com.example.aop.runner;

import com.example.aop.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EventServiceAopApplicationRunner implements ApplicationRunner {

    private final EventService eventService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        eventService.createEvent();
        eventService.deleteEvent();
        eventService.publishEvent();
    }
}
