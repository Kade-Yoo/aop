package com.example.aop.service.impl;

import com.example.aop.annotation.ProcessTimeLogging;
import com.example.aop.service.EventService;
import org.springframework.stereotype.Service;

@Service
public class EventServiceImpl implements EventService {

    @Override
    @ProcessTimeLogging
    public void createEvent() {
        try {
            Thread.sleep(1000);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Created an event");
    }

    @Override
    @ProcessTimeLogging
    public void publishEvent() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();;
        }
        System.out.println("Published an event");
    }

    @Override
    @ProcessTimeLogging
    public void deleteEvent() {
        System.out.println("Delete an event");
    }
}
