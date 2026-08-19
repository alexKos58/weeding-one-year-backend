package ru.kostyushin.backend.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.kostyushin.backend.dto.GuestRequest;
import ru.kostyushin.backend.dto.GuestResponse;
import ru.kostyushin.backend.service.GuestService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/guests")
@Tag(
        name = "Guests",
        description = "Работа с ответами гостей"
)
public class GuestController {

    private final GuestService guestService;

    public GuestController(GuestService guestService) {
        this.guestService = guestService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Создать ответ гостя")
    public GuestResponse create(
            @Valid @RequestBody GuestRequest request
    ) {
        return guestService.create(request);
    }

    @GetMapping
    @Operation(summary = "Получить ответы всех гостей")
    public List<GuestResponse> findAll() {
        return guestService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Получить ответ гостя по id")
    public GuestResponse findById(
            @PathVariable Long id
    ) {
        return guestService.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Удалить ответ гостя")
    public void delete(
            @PathVariable Long id
    ) {
        guestService.delete(id);
    }

}