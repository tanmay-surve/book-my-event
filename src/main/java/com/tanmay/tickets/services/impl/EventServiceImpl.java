package com.tanmay.tickets.services.impl;

import com.tanmay.tickets.domain.CreateEventRequest;
import com.tanmay.tickets.services.EventService;
import org.w3c.dom.events.Event;

import java.util.UUID;

public class EventServiceImpl implements EventService {
    @Override
    public Event createEvent(UUID organizerid, CreateEventRequest event) {
        return null;
    }
}
