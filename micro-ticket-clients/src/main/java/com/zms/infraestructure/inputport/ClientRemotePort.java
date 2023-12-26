package com.zms.infraestructure.inputport;

import com.zms.domain.model.dto.Clients;

public interface ClientRemotePort {
    Clients createClientFromRemote();
}
