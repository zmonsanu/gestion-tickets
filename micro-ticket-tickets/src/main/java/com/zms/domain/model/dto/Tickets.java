package com.zms.domain.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Getter
@Setter
@Entity
@Table(name="TICKETS")
public class Tickets implements Serializable {
    @Id
    @Column(name="id")
    private UUID id;

    @Column(name="description")
    private String description;

    @Column(name="eventid")
    private UUID eventId;

    @Column(name="clientid")
    private UUID clientId;

    @Column(name="dateofpurchase")
    private LocalDateTime dateOfPurchase;

    @Column(name="price")
    private double price;

    @Column(name = "validated")
    private boolean validated;


    public Tickets() {
        super();
    }

    public Tickets(UUID id, String description, UUID eventId, UUID clientId, LocalDateTime dateOfPurchase, double price, boolean validated) {
        this.id = id;
        this.description = description;
        this.eventId = eventId;
        this.clientId = clientId;
        this.dateOfPurchase = dateOfPurchase;
        this.price = price;
        this.validated  = validated;
    }

    @Override
    public String toString() {
        return "Tickets{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", eventId='" + eventId + '\'' +
                ", clientId='" + clientId + '\'' +
                ", dateOfPurchase=" + dateOfPurchase +
                ", price=" + price +
                ", validated=" + validated +
                '}';
    }
}
