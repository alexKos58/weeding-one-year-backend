package ru.kostyushin.backend.service;

import ru.kostyushin.backend.dto.GuestRequest;
import ru.kostyushin.backend.dto.GuestResponse;

import java.util.List;

public interface GuestService {

    GuestResponse create(GuestRequest request);

    List<GuestResponse> findAll();

    GuestResponse findById(Long id);

    void delete(Long id);

}