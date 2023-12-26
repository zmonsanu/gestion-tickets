package com.zms.infraestructure.rest.controller;

import com.zms.domain.model.dto.Tickets;
import com.zms.infraestructure.outputadapter.TicketOutPort;
import com.zms.infraestructure.outputadapter.TicketQROutPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value="tickets")
public class TicketAPI {
    @Autowired
    TicketOutPort ticketOutPort;

    @Autowired
    TicketQROutPort ticketQROutPort;


    @PostMapping(value="create", produces = MediaType.APPLICATION_JSON_VALUE)
    public Tickets create(@RequestParam String description, @RequestParam UUID eventId, @RequestParam UUID clientId, @RequestParam double price){
        return ticketOutPort.createTicket(description ,eventId, clientId, price);
    }

    @GetMapping(value = "get", produces=MediaType.APPLICATION_JSON_VALUE)
    public Tickets get(@PathVariable String id ) {
        return ticketOutPort.getById(UUID.fromString(id));
    }

    @GetMapping(value = "getall", produces=MediaType.APPLICATION_JSON_VALUE)
    public List<Tickets> getAll() {
        return ticketOutPort.getAll();
    }

    @PostMapping(value="validate", produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean validate(@RequestParam String id){
        return ticketOutPort.validate(id);
    }

    @PostMapping(value="generate", produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean generate(@RequestParam String id){
        Tickets[] lista = new Tickets[1];
        lista[0] = ticketOutPort.getById(UUID.fromString(id));
        ticketQROutPort.generateQRFromList(lista);
        return true;
    }

}
