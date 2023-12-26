package com.zms.infraestructure.outputadapter;

import com.zms.domain.model.dto.Tickets;

import java.util.List;
import java.util.UUID;

public interface TicketOutPort {
    Tickets createTicket(String description, UUID eventId, UUID clientId, double prize);
    Tickets getById(UUID id);
    List<Tickets> getAll();
    boolean validate(String id);
}
