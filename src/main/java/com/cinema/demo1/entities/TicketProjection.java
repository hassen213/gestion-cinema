package com.cinema.demo1.entities;

import org.springframework.data.rest.core.config.Projection;

import javax.persistence.*;

@Projection(name="ticketsProj",types=Ticket.class)
public interface TicketProjection {
    public Long getId();
    public String getNomClient();
    public double getPrix();
    public Integer getCodePayement();
    public boolean getReserve();
    public Place getPlace();
}
