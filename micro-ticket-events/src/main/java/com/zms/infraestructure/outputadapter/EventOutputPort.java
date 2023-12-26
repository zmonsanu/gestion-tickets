package com.zms.infraestructure.outputadapter;

import com.zms.domain.model.dto.Events;

import java.util.List;
import java.util.UUID;

public interface EventOutputPort {
    public Events createEvents(String description, String location, String production);
    public Events getById(UUID id);
    public List<Events> getAll();
}
