package com.tanmay.tickets.mappers;

import com.tanmay.tickets.domain.CreateEventRequest;
import com.tanmay.tickets.domain.CreateTicketTypeRequest;
import com.tanmay.tickets.domain.dtos.*;
import com.tanmay.tickets.domain.entities.Event;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EventMapper {

  CreateTicketTypeRequest fromDto(CreateTicketTypeRequestDto dto);

  CreateEventRequest fromDto(CreateEventRequestDto dto);

  CreateEventResponseDto toDto(Event event);

}
