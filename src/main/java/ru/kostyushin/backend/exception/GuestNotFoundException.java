package ru.kostyushin.backend.exception;

public class GuestNotFoundException extends RuntimeException {

    public GuestNotFoundException(Long id) {

        super("Гость с id = " + id + " не найден.");

    }

}
