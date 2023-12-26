package com.zms.infraestructure.rest.controller;

import com.zms.domain.model.dto.Clients;
import com.zms.infraestructure.inputport.ClientRemotePort;
import com.zms.infraestructure.outputadapter.ClientOutPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value="clients")
public class ClientAPI {
    @Autowired
    ClientOutPort clientOutPort;

    @Autowired
    ClientRemotePort clientRemotePort;

    @PostMapping(value="create", produces = MediaType.APPLICATION_JSON_VALUE)
    public Clients create(@RequestParam String first, @RequestParam String last, @RequestParam String email){
        return clientOutPort.createClient(first, last, email);
    }

    @GetMapping(value = "get", produces=MediaType.APPLICATION_JSON_VALUE)
    public Clients get(@PathVariable String id ) {
        return clientOutPort.getById(UUID.fromString(id));
    }

    @GetMapping(value = "getall", produces=MediaType.APPLICATION_JSON_VALUE)
    public List<Clients> getAll() {
        return clientOutPort.getAll();
    }

    @PostMapping(value="createRemote", produces = MediaType.APPLICATION_JSON_VALUE)
    public Clients createFromRemote(){
        return clientRemotePort.createClientFromRemote();
    }
}
