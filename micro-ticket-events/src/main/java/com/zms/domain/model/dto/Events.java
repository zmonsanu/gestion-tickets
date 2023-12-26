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
@Table(name="EVENTS")
public class Events implements Serializable {
    @Id
    @Column(name="id")
    private UUID id;
    @Column(name="description")
    private String description;
    @Column(name="location")
    private String location;
    @Column(name="production")
    private String production;

    @Column(name="eventdate")
    private LocalDateTime eventDate;

    public Events() {
        super();
    }

    public Events(UUID id, String description, String location, String production, LocalDateTime eventDate) {
        this.id = id;
        this.description = description;
        this.location = location;
        this.production = production;
        this.eventDate = eventDate;
    }

    @Override
    public String toString() {
        return "Events{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", location='" + location + '\'' +
                ", production='" + production + '\'' +
                ", eventDate='" + eventDate.toString() + '\'' +
                '}';
    }
}
