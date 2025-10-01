package com.tanmay.tickets.services;

import com.tanmay.tickets.domain.CreateEventRequest;
import org.w3c.dom.events.Event;

import java.util.UUID;

public interface EventService {
    Event createEvent(UUID organizerid, CreateEventRequest event);
}
