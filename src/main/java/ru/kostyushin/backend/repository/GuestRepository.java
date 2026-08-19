package ru.kostyushin.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kostyushin.backend.entity.Guest;

public interface GuestRepository extends JpaRepository<Guest, Long> {
}
