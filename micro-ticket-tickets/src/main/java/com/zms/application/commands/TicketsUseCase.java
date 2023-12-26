package com.zms.application.commands;

import com.zms.domain.model.dto.Tickets;
import com.zms.infraestructure.outputadapter.TicketOutPort;
import com.zms.infraestructure.outputadapter.TicketQROutPort;
import com.zms.infraestructure.outputport.EntityRepository;
import com.zms.infraestructure.qroutputport.QROutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

@Service
public class TicketsUseCase implements TicketOutPort, TicketQROutPort {


    @Autowired
    EntityRepository entityRepository;

    @Autowired
    QROutputPort qrOutputPort;
    @Override
    public Tickets createTicket(String description, UUID eventId, UUID clientId, double price) {
        Tickets tickets = Tickets.builder()
                .id(UUID.randomUUID())
                .description(description)
                .clientId(clientId)
                .eventId(eventId)
                .dateOfPurchase(generateRandomDateTime())
                .price(price)
                .validated(false)
                .build();
        return entityRepository.save(tickets);
    }

    @Override
    public Tickets getById(UUID id) {
        return entityRepository.findById(id).orElse(new Tickets());
    }

    @Override
    public List<Tickets> getAll() {
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
        return LocalDateTime.of(2023, month, day, hour, minute, second, nano);
    }


    @Override
    public void generateQRFromList(Tickets[] apiDataArray){
        for (Tickets apiData : apiDataArray) {
            qrOutputPort.saveQRToDisk(qrOutputPort.generateQR(apiData.getId().toString()), apiData.getId().toString());
        }
    }

    @Override
    public boolean validate(String id) {
        Optional<Tickets> ticket = entityRepository.findById(UUID.fromString(id));
        if (ticket.isPresent() && !ticket.get().isValidated()) {
            ticket.get().setValidated(true);
            entityRepository.save(ticket.get());
            return true;
        } else {
            return false;
        }
    }
}
