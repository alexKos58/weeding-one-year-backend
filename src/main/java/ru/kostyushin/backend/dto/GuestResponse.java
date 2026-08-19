package ru.kostyushin.backend.dto;

import ru.kostyushin.backend.entity.AttendanceStatus;
import ru.kostyushin.backend.entity.DrinkType;

import java.time.LocalDateTime;
import java.util.Set;

public record GuestResponse(

        Long id,

        String firstName,

        String lastName,

        AttendanceStatus attendanceStatus,

        Set<DrinkType> drinks,

        LocalDateTime createdAt

) {
}