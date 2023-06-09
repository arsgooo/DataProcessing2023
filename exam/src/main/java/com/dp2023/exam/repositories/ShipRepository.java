package com.dp2023.exam.repositories;

import com.dp2023.exam.entities.ShipEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "ships", path = "ships")
public interface ShipRepository extends JpaRepository<ShipEntity, Long> {
}
