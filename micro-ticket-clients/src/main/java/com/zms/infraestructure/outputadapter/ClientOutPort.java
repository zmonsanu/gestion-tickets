package com.zms.infraestructure.outputadapter;

import com.zms.domain.model.dto.Clients;

import java.util.List;
import java.util.UUID;

public interface ClientOutPort {
    Clients createClient(String first, String last, String email);
    Clients getById(UUID id);
    List<Clients> getAll();
}
