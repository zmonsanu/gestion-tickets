package com.zms.infraestructure.outputport;

import com.zms.domain.model.dto.Events;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EntityRepository extends JpaRepository<Events, UUID> {

}
