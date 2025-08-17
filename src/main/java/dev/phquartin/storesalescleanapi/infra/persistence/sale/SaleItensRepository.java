package dev.phquartin.storesalescleanapi.infra.persistence.sale;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleItensRepository extends JpaRepository<SaleItensEntity, Long> {
}
