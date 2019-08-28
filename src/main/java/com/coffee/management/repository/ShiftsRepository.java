package com.coffee.management.repository;

import com.coffee.management.entity.Shifts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShiftsRepository extends JpaRepository<Shifts, Long> {
}
