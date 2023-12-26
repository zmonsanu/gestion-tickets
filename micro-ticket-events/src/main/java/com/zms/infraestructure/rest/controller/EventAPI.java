package com.zms.infraestructure.rest.controller;

import com.zms.domain.model.dto.Events;
import com.zms.infraestructure.outputadapter.EventOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value="events")
public class EventAPI {
    @Autowired
    EventOutputPort eventInputPort;

    @PostMapping(value="create", produces = MediaType.APPLICATION_JSON_VALUE)
    public Events create(@RequestParam String description, @RequestParam String location, @RequestParam String production){
        return eventInputPort.createEvents(description, location, production);
    }

    @GetMapping(value = "get", produces=MediaType.APPLICATION_JSON_VALUE)
    public Events get(@PathVariable String id ) {
        return eventInputPort.getById(UUID.fromString(id));
    }

    @GetMapping(value = "getall", produces=MediaType.APPLICATION_JSON_VALUE)
    public List<Events> getAll() {
        return eventInputPort.getAll();
    }

}
