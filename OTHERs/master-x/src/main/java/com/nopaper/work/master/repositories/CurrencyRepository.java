package com.nopaper.work.master.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nopaper.work.master.models.Currency;

public interface CurrencyRepository extends JpaRepository<Currency, UUID> {

	List<Currency> findByStatus(String defaultStatus);
}
