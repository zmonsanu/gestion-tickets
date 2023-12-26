package com.zms.domain.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Builder
@Getter
@Setter
@Entity
@Table(name="CLIENTS")
public class Clients implements Serializable {

    @Id
    @Column(name="id")
    private UUID id;
    @Column(name="first")
    private String first;

    @Column(name="last")
    private String last;

    @Column(name="email")
    private String email;

    @Column(name="address")
    private String address;

    @Column(name="created")
    private String created;

    @Column(name="balance")
    private String balance;

    public Clients() {
        super();
    }

    public Clients(UUID id, String first, String last, String email, String address, String created, String balance) {
        this.id = id;
        this.first = first;
        this.last = last;
        this.email = email;
        this.address = address;
        this.created = created;
        this.balance = balance;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "ClientDTO{" +
                "id=" + id +
                ", first='" + first + '\'' +
                ", last='" + last + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", created='" + created + '\'' +
                ", balance='" + balance + '\'' +
                '}';
    }
}
