package ru.kostyushin.backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import ru.kostyushin.backend.entity.AttendanceStatus;
import ru.kostyushin.backend.entity.DrinkType;

import java.util.Set;

public record GuestRequest(

        @NotBlank(message = "Имя обязательно")
        String firstName,

        @NotBlank(message = "Фамилия обязательна")
        String lastName,

        @NotNull(message = "Необходимо указать участие")
        AttendanceStatus attendanceStatus,

        Set<DrinkType> drinks

) {
}
