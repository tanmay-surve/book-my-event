package com.tanmay.tickets.services;

import com.tanmay.tickets.domain.CreateEventRequest;
import com.tanmay.tickets.domain.entities.Event;
import com.tanmay.tickets.domain.entities.UpdateEventRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public interface EventService {
    Event createEvent(UUID organizerid, CreateEventRequest event);

    Page<Event> listEventsForOrganizer(UUID organizerId, Pageable pageable);


    Optional<Event> getEventForOrganizer(UUID organizerId, UUID id);

    Event updateEventForOrganizer(UUID organizerId, UUID id, UpdateEventRequest event);

    Optional<Event> getEventByOrganizerId(UUID organizerId, UUID id);
}
