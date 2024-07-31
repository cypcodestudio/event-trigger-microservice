package com.cypcode.event_trigger_microservice.controller;

import com.cypcode.event_trigger_microservice.domain.EventDTO;
import com.cypcode.event_trigger_microservice.service.EventHandlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventController {

    private final EventHandlerService eventHandlerService;

    public EventController(EventHandlerService eventHandlerService) {
        this.eventHandlerService = eventHandlerService;
    }

    @PostMapping("event")
    public String addEvent(@RequestBody EventDTO event) {
        return eventHandlerService.process(event) ? "success" : "fail";
    }
}
