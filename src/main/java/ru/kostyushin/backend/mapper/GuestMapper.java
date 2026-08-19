package ru.kostyushin.backend.mapper;

import org.springframework.stereotype.Component;
import ru.kostyushin.backend.dto.GuestRequest;
import ru.kostyushin.backend.dto.GuestResponse;
import ru.kostyushin.backend.entity.Guest;

import java.time.LocalDateTime;
import java.util.HashSet;

@Component
public class GuestMapper {

    public Guest toEntity(GuestRequest request) {

        Guest guest = new Guest();

        guest.setFirstName(request.firstName());
        guest.setLastName(request.lastName());
        guest.setAttendanceStatus(request.attendanceStatus());

        guest.setDrinks(
                request.drinks() == null
                        ? new HashSet<>()
                        : new HashSet<>(request.drinks())
        );

        guest.setCreatedAt(LocalDateTime.now());

        return guest;
    }

    public GuestResponse toResponse(Guest guest) {

        return new GuestResponse(
                guest.getId(),
                guest.getFirstName(),
                guest.getLastName(),
                guest.getAttendanceStatus(),
                guest.getDrinks(),
                guest.getCreatedAt()
        );

    }

}