package ru.kostyushin.backend.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kostyushin.backend.dto.GuestRequest;
import ru.kostyushin.backend.dto.GuestResponse;
import ru.kostyushin.backend.entity.AttendanceStatus;
import ru.kostyushin.backend.entity.Guest;
import ru.kostyushin.backend.exception.GuestNotFoundException;
import ru.kostyushin.backend.mapper.GuestMapper;
import ru.kostyushin.backend.repository.GuestRepository;
import ru.kostyushin.backend.service.GuestService;

import java.util.Collections;
import java.util.List;

@Service
@Transactional
public class GuestServiceImpl implements GuestService {

    private final GuestRepository repository;

    private final GuestMapper mapper;

    public GuestServiceImpl(
            GuestRepository repository,
            GuestMapper mapper
    ) {

        this.repository = repository;
        this.mapper = mapper;

    }

    @Override
    public GuestResponse create(GuestRequest request) {

        Guest guest = mapper.toEntity(request);
        if (guest.getAttendanceStatus() == AttendanceStatus.WILL_NOT_COME) {
            guest.setDrinks(Collections.emptySet());
        }

        Guest savedGuest = repository.save(guest);

        return mapper.toResponse(savedGuest);

    }

    @Override
    @Transactional(readOnly = true)
    public List<GuestResponse> findAll() {

        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();

    }

    @Override
    @Transactional(readOnly = true)
    public GuestResponse findById(Long id) {

        Guest guest = repository.findById(id)
                .orElseThrow(() -> new GuestNotFoundException(id));

        return mapper.toResponse(guest);

    }

    @Override
    public void delete(Long id) {

        if (!repository.existsById(id)) {
            throw new GuestNotFoundException(id);
        }

        repository.deleteById(id);

    }

}