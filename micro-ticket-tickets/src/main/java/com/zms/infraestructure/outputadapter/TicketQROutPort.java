package com.zms.infraestructure.outputadapter;

import com.zms.domain.model.dto.Tickets;

public interface TicketQROutPort {
    void generateQRFromList(Tickets[] ticket);
}
