package com.zms.application.commands;

import com.zms.domain.model.dto.Events;
import com.zms.infraestructure.outputadapter.EventOutputPort;
import com.zms.infraestructure.outputport.EntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
public class EventUseCase implements EventOutputPort {

    @Autowired
    EntityRepository entityRepository;

    @Override
    public Events createEvents(String description, String location, String production) {

        LocalTime localTime = LocalTime.now();
        Events evento = Events.builder()
                .id(UUID.randomUUID())
                .description(description)
                .location(location)
                .production(production)
                .eventDate(generateRandomDateTime())
                .build();

        return entityRepository.save(evento);
    }

    @Override
    public Events getById(UUID id) {
        return entityRepository.findById(id).orElse(new Events());
    }

    @Override
    public List<Events> getAll() {
        return entityRepository.findAll();
    }

    private LocalDateTime generateRandomDateTime() {
        Random random = new Random();
        int year = random.nextInt(3000) + 1;
        int month = random.nextInt(12) + 1;
        int day = random.nextInt(28) + 1; // Ajusta según el mes y tus necesidades
        int hour = random.nextInt(24);
        int minute = random.nextInt(60);
        int second = random.nextInt(60);
        int nano = random.nextInt(999999999 + 1);
        return LocalDateTime.of(2024, month, day, hour, minute, second, nano);
    }
}
