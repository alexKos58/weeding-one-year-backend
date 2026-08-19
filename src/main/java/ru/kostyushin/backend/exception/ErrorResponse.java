package ru.kostyushin.backend.exception;

import java.time.LocalDateTime;

public record ErrorResponse(

        LocalDateTime timestamp,

        int status,

        String error,

        String message,

        String path

) {
}