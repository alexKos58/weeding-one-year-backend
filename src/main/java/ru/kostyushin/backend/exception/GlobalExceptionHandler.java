package ru.kostyushin.backend.exception;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(GuestNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleGuestNotFound(

            GuestNotFoundException ex,

            HttpServletRequest request

    ) {

        return new ErrorResponse(

                LocalDateTime.now(),

                HttpStatus.NOT_FOUND.value(),

                HttpStatus.NOT_FOUND.getReasonPhrase(),

                ex.getMessage(),

                request.getRequestURI()

        );

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleValidation(

            MethodArgumentNotValidException ex,

            HttpServletRequest request

    ) {

        String message = ex.getBindingResult()

                .getFieldErrors()

                .stream()

                .map(error ->
                        error.getField() + ": " + error.getDefaultMessage())

                .collect(Collectors.joining(", "));

        return new ErrorResponse(

                LocalDateTime.now(),

                HttpStatus.BAD_REQUEST.value(),

                HttpStatus.BAD_REQUEST.getReasonPhrase(),

                message,

                request.getRequestURI()

        );

    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleConstraint(

            ConstraintViolationException ex,

            HttpServletRequest request

    ) {

        return new ErrorResponse(

                LocalDateTime.now(),

                HttpStatus.BAD_REQUEST.value(),

                HttpStatus.BAD_REQUEST.getReasonPhrase(),

                ex.getMessage(),

                request.getRequestURI()

        );

    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleOther(

            Exception ex,

            HttpServletRequest request

    ) {

        return new ErrorResponse(

                LocalDateTime.now(),

                HttpStatus.INTERNAL_SERVER_ERROR.value(),

                HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),

                ex.getMessage(),

                request.getRequestURI()

        );

    }

}